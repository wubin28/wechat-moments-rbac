package kata.ooadp.wechatmomentsrbac.domain;

public class Moment {
    private User user;
    private String contents;

    public Moment(User user, String contents) {
        this.user = user;
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public String getContents() {
        return contents;
    }
}
