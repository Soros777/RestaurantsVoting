package ua.dnipro.restaurantsvoting.model;

public class Restaurant extends AbstractBaseEntity{

    private String name;

    //@OneToOne
    private LunchMenu lunchMenu;

    public Restaurant(Integer id, String name, LunchMenu lunchMenu) {
        super(id);
        this.name = name;
        this.lunchMenu = lunchMenu;
    }

    public Restaurant(String restaurantName) {
        this(null, restaurantName, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lunchMenu=" + lunchMenu +
                '}';
    }
}
