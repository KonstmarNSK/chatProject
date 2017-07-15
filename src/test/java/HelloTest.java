import com.kostya.chatProject.configs.MainConfig;
import com.kostya.chatProject.entities.User;
import com.kostya.chatProject.repositories.interfaces.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Костя on 15.07.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MainConfig.class)
@ActiveProfiles("test")
public class HelloTest {
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    @WithMockUser
    public void checkHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.content().string("HELLO!"));
    }

    @Test
    public void checkRepository(){
        User user = new User();
        user.setPassword("123");
        user.setLogin("someLogin");
        userRepository.saveUser(user);

        User summonedUser = userRepository.getUserByUsername("someLogin");
        org.junit.Assert.assertNotNull(summonedUser);

    }
}
