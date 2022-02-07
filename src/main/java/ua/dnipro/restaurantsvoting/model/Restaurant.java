package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Restaurant.ALL, query = "SELECT r FROM Restaurant r"),
        @NamedQuery(name = Restaurant.ADD_VOTE, query = "UPDATE Restaurant r SET r.votes=r.votes+1 WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.RESET_VOTES, query = "UPDATE Restaurant r SET r.votes=0")
})

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity{
    public static final String ALL = "Restaurant.getAll";
    public static final String ADD_VOTE = "Restaurant.addVote";
    public static final String RESET_VOTES = "Restaurants.resetVotes";

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY)
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

    public Restaurant(Restaurant r) {
        this.id = r.id;
        this.name = r.name;
        this.lunchMenu = r.lunchMenu;
        this.votes = r.votes;
    }

    public Integer getVotes() {
        return votes;
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

    public void setVotes(Integer votes) {
        this.votes = votes;
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
