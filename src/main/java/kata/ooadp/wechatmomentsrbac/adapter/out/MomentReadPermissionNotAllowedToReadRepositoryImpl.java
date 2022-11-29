package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.adapter.out.stubdb.FakeFriendsDB;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {

    private final FakeFriendsDB fakeFriendsDB;

    @Autowired
    public MomentReadPermissionNotAllowedToReadRepositoryImpl(FakeFriendsDB fakeFriendsDB) {
        this.fakeFriendsDB = fakeFriendsDB;
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends friendsWhoAreNotAllowedToReadMyMoments = new Friends();
        friendsWhoAreNotAllowedToReadMyMoments.addAll(this.fakeFriendsDB.
                getFriendsWhoAreNotAllowedToReadMyMoments().stream()
                .map(addingFriend -> new AddingFriend(addingFriend.getMe(), addingFriend.getFriend()))
                .toList());
        return friendsWhoAreNotAllowedToReadMyMoments;
    }

}
