package ua.dnipro.restaurantsvoting.model;

public class User extends AbstractBaseEntity{
    private Role role;

    public User(Integer id, Role role) {
        super(id);
        this.role = role;
    }
}
