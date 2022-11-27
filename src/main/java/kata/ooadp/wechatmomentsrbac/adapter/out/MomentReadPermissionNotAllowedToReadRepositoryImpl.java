package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.Friend;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {

    private Friends friendsWhoAreNotAllowedToReadMyMoments;

    public MomentReadPermissionNotAllowedToReadRepositoryImpl() {
        this.friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.add(new Friend("zhao", "qian"));
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        for (Friend friend : this.friendsWhoAreNotAllowedToReadMyMoments) {
            friendsWhoAreNotAllowedToReadMyMoments.add(new Friend(friend.getMe().getUserAccount(), friend.getFriend().getUserAccount()));
        }
        return friendsWhoAreNotAllowedToReadMyMoments;
    }

}
