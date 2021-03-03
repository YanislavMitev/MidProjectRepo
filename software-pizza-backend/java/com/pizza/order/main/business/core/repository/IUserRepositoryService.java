package com.pizza.order.main.business.core.repository;

import com.pizza.order.main.models.user.User;

import java.util.function.Predicate;

/**
 * Public user repository interface supporting CRUD operations.
 */
public interface IUserRepositoryService {
    /**
     * Initialize the repository.
     */
    void initialize();

    /**
     * Register new user method.
     *
     * @param user is the new user.
     */
    void register(User user);

    /**
     * Find if user exists.
     *
     * @param userPredicate is the predicate the user is differed by.
     *
     * @return the user if found or null.
     */
    User findUser(Predicate<User> userPredicate);

    /**
     * Updates existing user.
     *
     * @param user is the user to be updated.
     */
    void updateUser(User user);

    /**
     * Deletes existing user.
     * @param userPredicate is the predicate the user is differed by.
     */
    void deleteUser(Predicate<User> userPredicate);
}
