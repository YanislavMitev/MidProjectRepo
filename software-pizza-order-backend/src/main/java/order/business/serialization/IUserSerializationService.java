package order.business.serialization;

import order.models.user.User;

import java.util.List;

/**
 * User serialization service.
 */
public interface IUserSerializationService {
    void serialize();

    List<User> deserialize();
}
