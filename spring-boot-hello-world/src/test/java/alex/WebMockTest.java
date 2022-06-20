package alex;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/** Created by qct on 2017/10/20. */
@WebMvcTest(HomeController.class)
public class WebMockTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private GreetingService greetingService;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        when(greetingService.greeting()).thenReturn("Hello Mock");
        mockMvc
                .perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }
}
