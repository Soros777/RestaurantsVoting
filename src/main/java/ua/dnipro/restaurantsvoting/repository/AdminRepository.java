package ua.dnipro.restaurantsvoting.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dnipro.restaurantsvoting.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AdminRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public <T extends AbstractBaseEntity> T saveEntity(T entity) {
        if(entity.isNew()) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }

    public Restaurant getRestaurantById(int restaurantId) {
        return em.find(Restaurant.class, restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return em.createNamedQuery(Restaurant.ALL, Restaurant.class).getResultList();
    }

    @Transactional
    public boolean resetAllVotes() {
        return em.createNamedQuery(Restaurant.RESET_VOTES)
                .executeUpdate() != 0 && em.createNamedQuery(User.RESET_VOTED).executeUpdate() != 0;
    }

    public List<User> getAllUsers() {
        return em.createNamedQuery(User.ALL, User.class).getResultList();
    }

    public List<LunchMenu> getAllLunchMenus() {
        return em.createNamedQuery(LunchMenu.ALL, LunchMenu.class).getResultList();
    }

    public LunchMenu getById(int lunchMenuId) {
        return em.find(LunchMenu.class, lunchMenuId);
    }

    @Transactional
    public boolean deleteDish(int id) {
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }
}
