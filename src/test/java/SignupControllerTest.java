import com.trenduce.controller.CollageController;
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


import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Created by prafulmantale on 1/2/15.
 */
public class SignupControllerTest {

    @InjectMocks
    private CollageController collageController;

    @InjectMocks
    private SignupController loginController;

    private MockMvc mockMvcCollage;
    private MockMvc mockMvcLogin;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvcCollage = MockMvcBuilders.standaloneSetup(collageController).build();

        mockMvcLogin = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void test() throws Exception{

       // mockMvcCollage.perform(get("/styles")).andDo(print());

        mockMvcLogin.perform(post("/signup").contentType(MediaType.APPLICATION_JSON).
                content("{\"userName\":\"pra\"," +
                "\"emailID\":\"a\",\"password\":\"\"}"))
                .andDo(print());
    }
}
