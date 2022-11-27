package kata.ooadp.wechatmomentsrbac.domain;

public class MomentReadPermission {
    private AddingFriend addingFriend;
    private Role role;

    public MomentReadPermission(AddingFriend addingFriend, Role role) {
        this.addingFriend = addingFriend;
        this.role = role;
    }

    public AddingFriend getAddingFriend() {
        return addingFriend;
    }

    public Role getRole() {
        return role;
    }
}
