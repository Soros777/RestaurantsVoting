package ua.dnipro.restaurantsvoting.model;

// @Table(name="dish", )
public class Dish extends AbstractBaseEntity{
    private String dishName;
    private Integer price;

    public Dish(Integer id, String dishName, Integer price) {
        super(id);
        this.dishName = dishName;
        this.price = price;
    }
}
