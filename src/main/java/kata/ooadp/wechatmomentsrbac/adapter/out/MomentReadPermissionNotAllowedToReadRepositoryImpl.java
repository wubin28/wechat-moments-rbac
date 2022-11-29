package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.adapter.out.db.FakeFriendsDB;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
        for (AddingFriend addingFriend : this.fakeFriendsDB.getFriendsWhoAreNotAllowedToReadMyMoments()) {
            friendsWhoAreNotAllowedToReadMyMoments.add(new AddingFriend(addingFriend.getMe(), addingFriend.getFriend()));
        }
        return friendsWhoAreNotAllowedToReadMyMoments;
    }

}
