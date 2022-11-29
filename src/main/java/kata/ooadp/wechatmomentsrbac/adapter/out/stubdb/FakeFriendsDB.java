package kata.ooadp.wechatmomentsrbac.adapter.out.stubdb;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import org.springframework.stereotype.Component;

@Component
public class FakeFriendsDB {
    private Friends friendsWhoAreNotAllowedToReadMyMoments;

    public FakeFriendsDB() {

    }

    public Friends getFriendsWhoAreNotAllowedToReadMyMoments() {
        return friendsWhoAreNotAllowedToReadMyMoments;
    }
}
