package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity{

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @OneToOne(mappedBy = "restaurant")
    private LunchMenu lunchMenu;

    @Column(name = "votes", nullable = false, columnDefinition = "integer default 0")
    private Integer votes = 0;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, LunchMenu lunchMenu) {
        super(id);
        this.name = name;
        this.lunchMenu = lunchMenu;
    }

    public Restaurant(String restaurantName) {
        this(null, restaurantName, null);
    }

    public Integer getVotes() {
        return votes;
    }

    public void resetVotes() {
        votes = 0;
    }

    public void incrementVotes() {
        votes++;
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
