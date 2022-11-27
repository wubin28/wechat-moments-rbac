package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.MomentReadPermissions;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.UsersInUserAccount;
import kata.ooadp.wechatmomentsrbac.application.port.out.ShowMomentsRepository;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.Moment;
import kata.ooadp.wechatmomentsrbac.domain.MomentReadPermission;
import kata.ooadp.wechatmomentsrbac.domain.Role;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class ShowMomentsRepositoryImpl implements ShowMomentsRepository {

    private MomentReadPermissions momentReadPermissions;
    private Moments allMoments;

    public ShowMomentsRepositoryImpl() {
        initializeAllMoments();
        initializeAllMomentReadPermissions();
    }

    private void initializeAllMomentReadPermissions() {
        this.momentReadPermissions = new MomentReadPermissions();
        momentReadPermissions.add(new MomentReadPermission(
                new AddingFriend(new User("zhao"), new User("qian")),
                new Role("not-allowed-to-read")
        ));
    }

    private void initializeAllMoments() {
        this.allMoments = new Moments();
        allMoments.add(new Moment(new User("zhao"), "zhao-contents-1"));
        allMoments.add(new Moment(new User("qian"), "qian-contents-1"));
        allMoments.add(new Moment(new User("sun"), "sun-contents-1"));
    }

    @Override
    public Moments findAllFilteredMoments(String userAccount) {
        UsersInUserAccount userNotAllowedReadFriend = userAllowedReadFriends(userAccount);
        return getUserMomentsTimeLine(userNotAllowedReadFriend);
    }

    private Moments getUserMomentsTimeLine(UsersInUserAccount userAllowedReadFriends) {
        Moments filteredMoments = new Moments();
        filteredMoments.addAll(this.allMoments.stream()
                .filter(moment -> isMomentAllowedRead(userAllowedReadFriends, moment))
                .toList());
        return filteredMoments;
    }

    private static boolean isMomentAllowedRead(UsersInUserAccount userNotAllowedReadFriend, Moment moment) {
        return userNotAllowedReadFriend.contains(moment.getUser().getUserAccount());
    }

    private UsersInUserAccount userAllowedReadFriends(String userAccount) {
        UsersInUserAccount userAllowedReadFriends = new UsersInUserAccount();
        userAllowedReadFriends.addAll(this.momentReadPermissions.stream()
                .filter(momentReadPermission -> momentReadPermission.getAddingFriend().getFriend().getUserAccount().equals(userAccount))
                .filter(momentReadPermission -> !momentReadPermission.getRole().getName().equals("not-allowed-to-read"))
                .map(momentReadPermission -> momentReadPermission.getAddingFriend().getMe().getUserAccount())
                .toList());
        userAllowedReadFriends.add(userAccount);
        return userAllowedReadFriends;
    }
}
