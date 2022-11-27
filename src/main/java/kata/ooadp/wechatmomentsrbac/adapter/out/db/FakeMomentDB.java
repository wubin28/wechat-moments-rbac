package kata.ooadp.wechatmomentsrbac.adapter.out.db;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.MomentReadPermissions;
import kata.ooadp.wechatmomentsrbac.domain.AddingFriend;
import kata.ooadp.wechatmomentsrbac.domain.Moment;
import kata.ooadp.wechatmomentsrbac.domain.MomentReadPermission;
import kata.ooadp.wechatmomentsrbac.domain.Role;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.stereotype.Component;

@Component()
public class FakeMomentDB {
    private MomentReadPermissions momentReadPermissions;
    private Moments allMoments;

    public FakeMomentDB() {
        this.initializeAllMoments();
        this.initializeAllMomentReadPermissions();
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

    public MomentReadPermissions getMomentReadPermissions() {
        return momentReadPermissions;
    }

    public Moments getAllMoments() {
        return allMoments;
    }
}
