package kata.ooadp.wechatmomentsrbac.application.port.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;

public interface MomentReadPermissionNotAllowedToReadRepository {
    Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount);
}
