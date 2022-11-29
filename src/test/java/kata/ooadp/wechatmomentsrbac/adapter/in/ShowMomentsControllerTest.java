package kata.ooadp.wechatmomentsrbac.adapter.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.db.FakeMomentDB;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.MomentReadPermissions;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.Moment;
import kata.ooadp.wechatmomentsrbac.domain.MomentReadPermission;
import kata.ooadp.wechatmomentsrbac.domain.Role;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ShowMomentsControllerTest {

    @Autowired
    MockMvc client;
    @MockBean
    FakeMomentDB fakeMomentDB;

    /**
     * AddingFriend
     * <p>
     * me     friend
     * --     ------
     * zhao   qian (not allowed to read)
     * sun
     * li
     * <p>
     * Moment
     * <p>
     * user     contents
     * ----     --------
     * zhao     zhao-contents-1
     * qian     qian-contents-1
     *
     * @throws Exception
     */
    @Test
    void should_find_All_Filtered_Moments() throws Exception {
        Moments allMoments = new Moments();
        allMoments.add(new Moment(new User("zhao"), "zhao-contents-1"));
        allMoments.add(new Moment(new User("qian"), "qian-contents-1"));
        allMoments.add(new Moment(new User("sun"), "sun-contents-1"));
        when(fakeMomentDB.getAllMoments()).thenReturn(allMoments);
        MomentReadPermissions momentReadPermissions = new MomentReadPermissions();
        momentReadPermissions.add(new MomentReadPermission(
                new AddingFriend(new User("zhao"), new User("qian")),
                new Role("not-allowed-to-read")
        ));
        when(fakeMomentDB.getMomentReadPermissions()).thenReturn(momentReadPermissions);

        client.perform(MockMvcRequestBuilders.get("/moments?userAccount=qian"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user.userAccount").value("qian"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].contents").value("qian-contents-1"));
    }
}