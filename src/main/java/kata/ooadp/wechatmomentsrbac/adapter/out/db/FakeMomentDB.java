package kata.ooadp.wechatmomentsrbac.adapter.out.db;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.MomentReadPermissions;
import org.springframework.stereotype.Component;

@Component
public class FakeMomentDB {
    private MomentReadPermissions momentReadPermissions;
    private Moments allMoments;

    public FakeMomentDB() {

    }
    public MomentReadPermissions getMomentReadPermissions() {
        return momentReadPermissions;
    }

    public Moments getAllMoments() {
        return allMoments;
    }
}
