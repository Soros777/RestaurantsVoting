package ua.dnipro.restaurantsvoting.model;

public class User extends AbstractBaseEntity{
    private Role role;
    private boolean votedToday = false;

    public User(Integer id, Role role) {
        super(id);
        this.role = role;
    }

    public User(Role role) {
        this(null, role);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isVotedToday() {
        return votedToday;
    }

    public void setVotedToday(boolean votedToday) {
        this.votedToday = votedToday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", votedToday=" + votedToday +
                '}';
    }
}
