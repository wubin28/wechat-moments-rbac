package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import kata.ooadp.wechatmomentsrbac.domain.Friend;
import org.springframework.stereotype.Repository;

@Repository
public class MomentReadPermissionNotAllowedToReadRepositoryImpl implements MomentReadPermissionNotAllowedToReadRepository {
    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        Friends result = new Friends();
        result.add(new Friend("zhao", "sun"));
        result.add(new Friend("zhao", "li"));
        return result;
    }
}
