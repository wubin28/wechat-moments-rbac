package kata.ooadp.wechatmomentsrbac.adapter.out.stubdb;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.adapter.out.pojo.MomentReadPermissions;
import org.springframework.stereotype.Component;

@Component
public class ShowMomentsServiceStubDb {
    private MomentReadPermissions momentReadPermissions;
    private Moments allMoments;

    public ShowMomentsServiceStubDb() {

    }
    public MomentReadPermissions getMomentReadPermissions() {
        return momentReadPermissions;
    }

    public Moments getAllMoments() {
        return allMoments;
    }
}
