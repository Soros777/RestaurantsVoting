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

    public Dish(String dishName, int price) {
        this(null, dishName, price);
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                '}';
    }
}
