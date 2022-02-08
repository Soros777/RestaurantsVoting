package ua.dnipro.restaurantsvoting.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User save(User user) {
        if(user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Transactional
    public boolean doVote(int restaurantId, User user) {
        if(em.createNamedQuery(Restaurant.ADD_VOTE)
                .setParameter("id", restaurantId)
                .executeUpdate() == 0) {
            return false;
        }
        user.setVotedToday(true);
        em.merge(user);
        return true;
    }

    public List<LunchMenu> getAllLunchMenus() {
        return em.createNamedQuery(LunchMenu.ALL, LunchMenu.class).getResultList();
    }
}
