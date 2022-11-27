package kata.ooadp.wechatmomentsrbac.application.port.in;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;

public interface ShowMomentsService {
    Moments findAllFilteredMoments(String userAccount);
}
