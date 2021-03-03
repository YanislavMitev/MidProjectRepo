package order.business.repository;

import order.models.user.User;

import java.util.List;

/**
 * User repository interface.
 */
public interface IUserRepository {
    List<User> extractAll();

    User getUser(String name);

    boolean exists(String name);
}
