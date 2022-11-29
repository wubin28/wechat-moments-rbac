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
class ShowMomentsControllerTest {

    @Autowired
    MockMvc client;

    /**
     * AddingFriend
     *
     * me     friend
     * --     ------
     * zhao   qian (not allowed to read)
     *        sun
     *        li
     *
     * Moment
     *
     * user     contents
     * ----     --------
     * zhao     zhao-contents-1
     * qian     qian-contents-1
     * @throws Exception
     */
    @Test
    void should_find_All_Filtered_Moments() throws Exception {
        client.perform(MockMvcRequestBuilders.get("/moments?userAccount=qian"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.userAccount").value("qian"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].contents").value("qian-contents-1"));
    }
}