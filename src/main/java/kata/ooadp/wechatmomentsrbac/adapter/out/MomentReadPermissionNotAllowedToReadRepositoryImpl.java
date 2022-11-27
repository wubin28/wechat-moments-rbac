package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.Friend;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {

    private final Friends friends;

    public MomentReadPermissionNotAllowedToReadRepositoryImpl() {
        this.friends = new Friends();
        friends.add(new Friend("zhao", "qian"));
        friends.add(new Friend("zhao", "sun"));
        friends.add(new Friend("zhao", "li"));
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends result = new Friends();
        result.add(new Friend(friends.get(0).getMe().getUserAccount(), friends.get(0).getFriend().getUserAccount()));
        return result;
    }
}
