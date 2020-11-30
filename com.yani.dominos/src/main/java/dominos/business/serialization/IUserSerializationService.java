package dominos.business.serialization;

import dominos.models.user.User;

import java.util.List;

/**
 * User serialization service.
 */
public interface IUserSerializationService {
    void serialize();

    List<User> deserialize();
}
