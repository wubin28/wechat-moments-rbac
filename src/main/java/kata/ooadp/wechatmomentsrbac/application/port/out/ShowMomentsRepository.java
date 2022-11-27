package kata.ooadp.wechatmomentsrbac.application.port.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;

public interface ShowMomentsRepository {
    Moments findAllFilteredMoments(String userAccount);
}
