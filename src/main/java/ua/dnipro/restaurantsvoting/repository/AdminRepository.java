package ua.dnipro.restaurantsvoting.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dnipro.restaurantsvoting.model.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class AdminRepository {

    @PersistenceContext
    private EntityManager em;

    public Restaurant getRestaurantById(int restaurantId) {
        return em.find(Restaurant.class, restaurantId);
    }
}
