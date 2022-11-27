package kata.ooadp.wechatmomentsrbac.domain;

public class AddingFriend {
    private User me;
    private User friend;

    public AddingFriend(User me, User friend) {
        this.me = me;
        this.friend = friend;
    }

    public User getMe() {
        return me;
    }

    public User getFriend() {
        return friend;
    }
}
