package kata.ooadp.wechatmomentsrbac.application.port.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.domain.User;

public interface MomentReadPermissionNotAllowedToReadService {
    Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount);
}
