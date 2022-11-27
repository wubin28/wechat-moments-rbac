package kata.ooadp.wechatmomentsrbac.application.service;

import kata.ooadp.wechatmomentsrbac.adapter.in.pojo.Friends;
import kata.ooadp.wechatmomentsrbac.application.port.in.MomentReadPermissionNotAllowedToReadService;
import kata.ooadp.wechatmomentsrbac.application.port.out.MomentReadPermissionNotAllowedToReadRepository;
import org.springframework.stereotype.Service;

@Service
public class MomentReadPermissionNotAllowedToReadServiceImpl implements MomentReadPermissionNotAllowedToReadService {

    private MomentReadPermissionNotAllowedToReadRepository momentReadPermissionNotAllowedToReadRepository;

    public MomentReadPermissionNotAllowedToReadServiceImpl(MomentReadPermissionNotAllowedToReadRepository momentReadPermissionNotAllowedToReadRepository) {
        this.momentReadPermissionNotAllowedToReadRepository = momentReadPermissionNotAllowedToReadRepository;
    }

    @Override
    public Friends findAllFriendsWhoAreNotAllowedToReadMyMoments(String userAccount) {
        return momentReadPermissionNotAllowedToReadRepository.findAllFriendsWhoAreNotAllowedToReadMyMoments(userAccount);
    }
}
