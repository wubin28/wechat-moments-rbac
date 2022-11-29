package kata.ooadp.wechatmomentsrbac.adapter.out.db;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.stereotype.Component;

@Component
public class FakeFriendsDB {
    private Friends friendsWhoAreNotAllowedToReadMyMoments;

    public FakeFriendsDB() {
        this.friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.add(new AddingFriend(new User("zhao"), new User("qian")));
    }

    public Friends getFriendsWhoAreNotAllowedToReadMyMoments() {
        return friendsWhoAreNotAllowedToReadMyMoments;
    }
}
