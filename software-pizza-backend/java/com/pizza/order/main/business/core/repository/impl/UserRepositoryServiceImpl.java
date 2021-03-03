package com.pizza.order.main.business.core.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizza.order.main.business.core.repository.IUserRepositoryService;
import com.pizza.order.main.models.user.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserRepositoryServiceImpl implements IUserRepositoryService {
    private List<User> users = new ArrayList<>();

    public void initialize() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream resource = UserRepositoryServiceImpl.class.getResourceAsStream("/usersRepo.json");

            users = objectMapper.readValue(resource, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Invalid user.");
        }

        users.add(user);
    }

    @Override
    public User findUser(Predicate<User> userPredicate) {
        return users.stream()
                    .filter(userPredicate)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Predicate<User> userPredicate) {

    }
}
