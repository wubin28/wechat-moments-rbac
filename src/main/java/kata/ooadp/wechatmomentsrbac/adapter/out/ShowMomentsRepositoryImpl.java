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
    }

    @Override
    public Moments findAllFilteredMoments(String userAccount) {
        UsersInUserAccount usersInUserAccountWhoConfiguredNotAllowedToRead = new UsersInUserAccount();
        for (MomentReadPermission momentReadPermission : this.momentReadPermissions){
            if (momentReadPermission.getRole().getName().equals("not-allowed-to-read")) {
                if (momentReadPermission.getAddingFriend().getFriend().getUserAccount().equals(userAccount)) {
                    usersInUserAccountWhoConfiguredNotAllowedToRead.add(momentReadPermission.getAddingFriend().getMe().getUserAccount());
                }
            }
        }
        Moments filteredMoments = new Moments();
        for (Moment moment : this.allMoments) {
            if (!usersInUserAccountWhoConfiguredNotAllowedToRead.contains(moment.getUser().getUserAccount())) {
                filteredMoments.add(new Moment(new User(moment.getUser().getUserAccount()), moment.getContents()));
            }
        }
        return filteredMoments;
    }
}
