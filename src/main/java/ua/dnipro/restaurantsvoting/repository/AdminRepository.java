package ua.dnipro.restaurantsvoting.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dnipro.restaurantsvoting.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AdminRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Restaurant saveRestaurant(Restaurant restaurant) {
        if(restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    public Restaurant getRestaurantById(int restaurantId) {
        return em.find(Restaurant.class, restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return em.createNamedQuery(Restaurant.ALL, Restaurant.class).getResultList();
    }
}
