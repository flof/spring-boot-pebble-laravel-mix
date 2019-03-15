package at.lingu.laravelmix;

import at.lingu.laravelmix.model.Person;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MixApplication.class})
@AutoConfigureMockMvc
public class PersonServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceTest.class);

    @Autowired
    private MockMvc mvc;
    private String urlPrefix = "/api/v1/people";

    @Test
    public void testCreate() throws Exception {
        Gson gson = new Gson();
        Person person = new Person();
        person.setName("nikola.tesla");
        person.setDisplayName("Никола Тесла");
        mvc.perform(
                post(urlPrefix)
                        .contentType(APPLICATION_JSON)
                        .content(gson.toJson(person))
        ).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testList() throws Exception {
        mvc.perform(get(urlPrefix)).andExpect(status().is2xxSuccessful());
    }

}
