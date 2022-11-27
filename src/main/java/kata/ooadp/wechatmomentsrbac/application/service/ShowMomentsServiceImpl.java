package kata.ooadp.wechatmomentsrbac.application.service;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.application.port.in.ShowMomentsService;
import kata.ooadp.wechatmomentsrbac.application.port.out.ShowMomentsRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowMomentsServiceImpl implements ShowMomentsService {

    private ShowMomentsRepository showMomentsRepository;

    public ShowMomentsServiceImpl(ShowMomentsRepository showMomentsRepository) {
        this.showMomentsRepository = showMomentsRepository;
    }

    @Override
    public Moments findAllFilteredMoments(String userAccount) {
        return showMomentsRepository.findAllFilteredMoments(userAccount);
    }
}
