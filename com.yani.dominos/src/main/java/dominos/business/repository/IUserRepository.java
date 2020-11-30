package dominos.business.repository;

import dominos.models.user.User;

import java.util.List;

/**
 * User repository interface.
 */
public interface IUserRepository {
    List<User> extractAll();

    User getUser(String name);

    boolean exists(String name);
}
