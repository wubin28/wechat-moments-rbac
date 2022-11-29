package kata.ooadp.wechatmomentsrbac.adapter.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.adapter.out.stubdb.FakeFriendsDB;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MomentReadPermissionNotAllowedToReadControllerTest {

    @Autowired
    MockMvc client;
    @MockBean
    FakeFriendsDB fakeFriendsDB;


    /**
     * AddingFriend
     * <p>
     * me     friend
     * --     ------
     * zhao   qian (not allowed to read)
     * sun
     * li
     *
     * @throws Exception
     */
    @Test
    void should_find_All_Friends_Who_Are_Not_Allowed_To_Read_My_Moments() throws Exception {

        Friends friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.add(new AddingFriend(new User("zhao"), new User("qian")));
        when(fakeFriendsDB.getFriendsWhoAreNotAllowedToReadMyMoments()).thenReturn(friendsWhoAreNotAllowedToReadMyMoments);
        client.perform(MockMvcRequestBuilders.get("/moment-read-permissions-not-allowed-to-read?userAccount=zhao"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].me.userAccount").value("zhao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].friend.userAccount").value("qian"));
    }
}