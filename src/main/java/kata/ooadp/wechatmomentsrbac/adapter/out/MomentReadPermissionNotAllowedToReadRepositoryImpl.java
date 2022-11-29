package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.adapter.out.stubdb.MomentReadPermissionNotAllowedToServiceStubDb;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {

    private final MomentReadPermissionNotAllowedToServiceStubDb momentReadPermissionNotAllowedToServiceStubDb;

    @Autowired
    public MomentReadPermissionNotAllowedToReadRepositoryImpl(MomentReadPermissionNotAllowedToServiceStubDb momentReadPermissionNotAllowedToServiceStubDb) {
        this.momentReadPermissionNotAllowedToServiceStubDb = momentReadPermissionNotAllowedToServiceStubDb;
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.addAll(this.momentReadPermissionNotAllowedToServiceStubDb.
                getFriendsWhoAreNotAllowedToReadMyMoments().stream()
                .map(addingFriend -> new AddingFriend(addingFriend.getMe(), addingFriend.getFriend()))
                .toList());
        return friendsWhoAreNotAllowedToReadMyMoments;
    }

}
