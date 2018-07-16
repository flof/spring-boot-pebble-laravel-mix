package at.lingu.laravelmix.web;

import com.mitchellbosecke.pebble.attributes.AttributeResolver;
import com.mitchellbosecke.pebble.extension.*;
import com.mitchellbosecke.pebble.operator.BinaryOperator;
import com.mitchellbosecke.pebble.operator.UnaryOperator;
import com.mitchellbosecke.pebble.tokenParser.TokenParser;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class LaravelMixExtension implements Extension {

    private final MixFunction mixFunction;

    public LaravelMixExtension(MixFunction mixFunction) {
        this.mixFunction = mixFunction;
    }

    @Override
    public Map<String, Filter> getFilters() {
        return null;
    }

    @Override
    public Map<String, Test> getTests() {
        return null;
    }

    @Override
    public Map<String, Function> getFunctions() {
        return Collections.singletonMap("mix", mixFunction);
    }

    @Override
    public List<TokenParser> getTokenParsers() {
        return null;
    }

    @Override
    public List<BinaryOperator> getBinaryOperators() {
        return null;
    }

    @Override
    public List<UnaryOperator> getUnaryOperators() {
        return null;
    }

    @Override
    public Map<String, Object> getGlobalVariables() {
        return null;
    }

    @Override
    public List<NodeVisitorFactory> getNodeVisitors() {
        return null;
    }

    @Override
    public List<AttributeResolver> getAttributeResolver() {
        return null;
    }
}
