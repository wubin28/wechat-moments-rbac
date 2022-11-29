package kata.ooadp.wechatmomentsrbac.adapter.out.stubdb;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import org.springframework.stereotype.Component;

@Component
public class MomentReadPermissionNotAllowedToServiceStubDb {
    private Friends friendsWhoAreNotAllowedToReadMyMoments;

    public MomentReadPermissionNotAllowedToServiceStubDb() {

    }

    public Friends getFriendsWhoAreNotAllowedToReadMyMoments() {
        return friendsWhoAreNotAllowedToReadMyMoments;
    }
}
