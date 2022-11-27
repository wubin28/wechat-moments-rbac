package kata.ooadp.wechatmomentsrbac.domain;

public class Friend {
    private User me;
    private User friend;

    public Friend(String me, String friend) {
        this.me = new User(me);
        this.friend = new User(friend);
    }

    public User getMe() {
        return me;
    }

    public User getFriend() {
        return friend;
    }
}
