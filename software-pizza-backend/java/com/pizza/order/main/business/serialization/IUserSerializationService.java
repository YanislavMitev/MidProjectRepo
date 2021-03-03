package com.pizza.order.main.business.serialization;

import com.pizza.order.main.models.user.User;

import java.util.List;

/**
 * User serialization service.
 */
public interface IUserSerializationService {
    void serialize();

    List<User> deserialize();
}
