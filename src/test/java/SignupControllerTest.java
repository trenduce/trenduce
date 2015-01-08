import com.trenduce.controller.HomeController;
import com.trenduce.controller.LoginController;
import com.trenduce.controller.SignupController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupControllerTest {

    @InjectMocks
    private LoginController controller;

    private MockMvc mockMvc;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception{

        //mockMvc.perform(get("/login")).andDo(print());

        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).
                content("{\"userName\":\"pra\"," +
                "\"emailID\":\"a\",\"password\":\"\"}"))
                .andDo(print());
    }
}
