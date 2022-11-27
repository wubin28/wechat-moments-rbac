package kata.ooadp.wechatmomentsrbac.domain;

public class User {
    private String userAccount;

    public User(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return userAccount;
    }
}
