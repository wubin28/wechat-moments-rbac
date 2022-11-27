package kata.ooadp.wechatmomentsrbac.adapter.out;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Moments;
import kata.ooadp.wechatmomentsrbac.application.port.out.ShowMomentsRepository;
import kata.ooadp.wechatmomentsrbac.domain.Moment;
import kata.ooadp.wechatmomentsrbac.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class ShowMomentsRepositoryImpl implements ShowMomentsRepository {

    private Moments filteredMoments;

    public ShowMomentsRepositoryImpl() {
        this.filteredMoments = new Moments();
        filteredMoments.add(new Moment(new User("qian"), "qian-contents-1"));
    }

    @Override
    public Moments findAllFilteredMoments(String userAccount) {
        Moments filteredMoments = new Moments();
        for (Moment moment : this.filteredMoments) {
            filteredMoments.add(new Moment(new User(moment.getUser().getUserAccount()), moment.getContents()));
        }
        return filteredMoments;
    }
}
