package ua.dnipro.restaurantsvoting.repository.inMemory;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.Vote;
import ua.dnipro.restaurantsvoting.repository.VoteRepository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class VoteMemRepo extends InMemoryBaseRepository<Vote> implements VoteRepository {

    @Override
    public Set<Vote> getAll() {
        return new HashSet<>(super.getAll());
    }
}
