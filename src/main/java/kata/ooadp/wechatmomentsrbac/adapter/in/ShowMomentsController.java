package kata.ooadp.wechatmomentsrbac.adapter.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.application.port.in.ShowMomentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moments")
public class ShowMomentsController {

    private ShowMomentsService showMomentsService;

    public ShowMomentsController(ShowMomentsService showMomentsService) {
        this.showMomentsService = showMomentsService;
    }

    @GetMapping(params = {"userAccount"})
    public Moments findAllFilteredMoments(@RequestParam("userAccount") String userAccount) {
        return showMomentsService.findAllFilteredMoments(userAccount);
    }
}
