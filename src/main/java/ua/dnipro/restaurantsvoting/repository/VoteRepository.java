package ua.dnipro.restaurantsvoting.repository;

import ua.dnipro.restaurantsvoting.model.Vote;

import java.util.Set;

public interface VoteRepository {

    Vote save(Vote vote);

    Set<Vote> getAll();
}
