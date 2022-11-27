package kata.ooadp.wechatmomentsrbac.adapter.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.in.MomentReadPermissionNotAllowedToReadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moment-read-permissions-not-allowed-to-read")
public class MomentReadPermissionNotAllowedToReadController {

    private MomentReadPermissionNotAllowedToReadService momentReadPermissionNotAllowedToReadService;

    public MomentReadPermissionNotAllowedToReadController(MomentReadPermissionNotAllowedToReadService momentReadPermissionNotAllowedToReadService) {
        this.momentReadPermissionNotAllowedToReadService = momentReadPermissionNotAllowedToReadService;
    }

    @GetMapping(params = {"userAccount"})
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(@RequestParam("userAccount") String userAccount) {
        return momentReadPermissionNotAllowedToReadService.findAllFriendsWhoAreNotAllowedToReadMyMoments(userAccount);
    }


}
