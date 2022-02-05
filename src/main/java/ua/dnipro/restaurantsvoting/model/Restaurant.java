package ua.dnipro.restaurantsvoting.model;

public class Restaurant extends AbstractBaseEntity{

    //@OneToOne
    private LunchMenu lunchMenu;

    public Restaurant(Integer id, LunchMenu lunchMenu) {
        super(id);
        this.lunchMenu = lunchMenu;
    }
}
