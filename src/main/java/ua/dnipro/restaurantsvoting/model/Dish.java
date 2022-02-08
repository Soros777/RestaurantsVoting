package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id")
})

@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity{
    public static final String DELETE = "Dish.delete";

    @Column(name = "dish_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String dishName;

    @Column(name = "price", nullable = false, columnDefinition = "integer")
    @NotNull
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "lunch_menu_id")
    private LunchMenu lunchMenu;

    public Dish() {
    }

    public Dish(Integer id, String dishName, Integer price) {
        super(id);
        this.dishName = dishName;
        this.price = price;
    }

    public Dish(Integer id, String dishName, Integer price, LunchMenu lunchMenu) {
        super(id);
        this.dishName = dishName;
        this.price = price;
        this.lunchMenu = lunchMenu;
    }

    public Dish(@NotNull String dishName, @NotNull Integer price) {
        this(null, dishName, price);
    }

    public Dish(Dish d) {
        this.id = d.id;
        this.dishName = d.dishName;
        this.price = d.price;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
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
