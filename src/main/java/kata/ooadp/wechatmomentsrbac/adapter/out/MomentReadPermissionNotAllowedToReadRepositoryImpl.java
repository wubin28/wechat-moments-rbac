package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {

    private Friends friendsWhoAreNotAllowedToReadMyMoments;

    public MomentReadPermissionNotAllowedToReadRepositoryImpl() {
        this.friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.add(new AddingFriend(new User("zhao"), new User("qian")));
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        for (AddingFriend addingFriend : this.friendsWhoAreNotAllowedToReadMyMoments) {
            friendsWhoAreNotAllowedToReadMyMoments.add(new AddingFriend(addingFriend.getMe(), addingFriend.getFriend()));
        }
        return friendsWhoAreNotAllowedToReadMyMoments;
    }

}
