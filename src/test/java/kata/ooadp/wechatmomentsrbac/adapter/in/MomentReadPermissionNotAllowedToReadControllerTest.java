package kata.ooadp.wechatmomentsrbac.adapter.in;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MomentReadPermissionNotAllowedToReadControllerTest {

    @Autowired
    MockMvc client;


    @Test
    void should_find_All_Friends_Who_Are_Not_Allowed_To_Read_My_Moments() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/moment-read-permissions-not-allowed-to-read?userAccount=zhao"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].me.userAccount").value("zhao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].friend.userAccount").value("li"));
    }
}