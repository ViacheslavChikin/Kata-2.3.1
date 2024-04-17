package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void deleteUser(Long id);

    public void editUser(User updateUser);

    User getUserById(Long id);

    List<User> getUsers();
}
