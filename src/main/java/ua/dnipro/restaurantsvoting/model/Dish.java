package ua.dnipro.restaurantsvoting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity{

    @Column(name = "dish_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String dishName;

    @Column(name = "price", nullable = false, columnDefinition = "integer")
    @NotNull
    private Integer price;

    public Dish() {
    }

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
