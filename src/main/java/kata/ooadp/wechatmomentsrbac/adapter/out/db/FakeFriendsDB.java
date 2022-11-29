package kata.ooadp.wechatmomentsrbac.adapter.out.db;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.User;
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
