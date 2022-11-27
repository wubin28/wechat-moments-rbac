package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.db.FakeMomentDB;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.UsersInUserAccount;
import kata.ooadp.wechatmomentsrbac.application.port.out.ShowMomentsRepository;
import kata.ooadp.wechatmomentsrbac.domain.Moment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShowMomentsRepositoryImpl implements ShowMomentsRepository {

    private final FakeMomentDB fakeMomentDB;

    @Autowired
    public ShowMomentsRepositoryImpl(FakeMomentDB fakeMomentDB) {
        this.fakeMomentDB = fakeMomentDB;
    }


    @Override
    public Moments findAllFilteredMoments(String userAccount) {
        UsersInUserAccount userNotAllowedReadFriend = userAllowedReadFriends(userAccount);
        return getUserMomentsTimeLine(userNotAllowedReadFriend);
    }

    private Moments getUserMomentsTimeLine(UsersInUserAccount userAllowedReadFriends) {
        Moments filteredMoments = new Moments();
        filteredMoments.addAll(fakeMomentDB.getAllMoments().stream()
                .filter(moment -> isMomentAllowedRead(userAllowedReadFriends, moment))
                .toList());
        return filteredMoments;
    }

    private static boolean isMomentAllowedRead(UsersInUserAccount userAllowedReadFriends, Moment moment) {
        return userAllowedReadFriends.contains(moment.getUser().getUserAccount());
    }

    private UsersInUserAccount userAllowedReadFriends(String userAccount) {
        UsersInUserAccount userAllowedReadFriends = new UsersInUserAccount();
        userAllowedReadFriends.addAll(fakeMomentDB.getMomentReadPermissions().stream()
                .filter(momentReadPermission -> momentReadPermission.getAddingFriend().getFriend().getUserAccount().equals(userAccount))
                .filter(momentReadPermission -> !momentReadPermission.getRole().getName().equals("not-allowed-to-read"))
                .map(momentReadPermission -> momentReadPermission.getAddingFriend().getMe().getUserAccount())
                .toList());
        userAllowedReadFriends.add(userAccount);
        return userAllowedReadFriends;
    }
}
