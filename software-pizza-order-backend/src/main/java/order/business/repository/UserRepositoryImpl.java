package order.business.repository;

import order.models.user.User;

import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    @Override
    public List<User> extractAll() {
        return null;
    }

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public boolean exists(String name) {
        return false;
    }
}
