package at.lingu.laravelmix.web;

import com.mitchellbosecke.pebble.boot.autoconfigure.PebbleProperties;
import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MixFunction implements Function {

    private final ResourceLoader resourceLoader;

    private final JsonParser jsonParser;

    private final PebbleProperties pebbleProperties;

    private Map<String, Object> cache;

    public MixFunction(ResourceLoader resourceLoader, PebbleProperties pebbleProperties) {
        this.resourceLoader = resourceLoader;
        this.pebbleProperties = pebbleProperties;
        this.jsonParser = JsonParserFactory.getJsonParser();
    }

    @Override
    public Object execute(Map<String, Object> map, PebbleTemplate pebbleTemplate, EvaluationContext evaluationContext, int i) {
        String key = (String) map.get("path");
        try {
            if (!pebbleProperties.isCache() || cache == null) {
                Resource manifestation = resourceLoader.getResource("classpath:static/mix-manifest.json");
                String json = StreamUtils.copyToString(manifestation.getInputStream(), Charset.forName("UTF-8"));
                cache = jsonParser.parseMap(json);
            }
            return cache.get(key);
        } catch (Exception e) {
            return key;
        }
    }

    @Override
    public List<String> getArgumentNames() {
        List<String> names = new ArrayList<>();
        names.add("path");
        return names;
    }
}
