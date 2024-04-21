package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void addUser(User user) {
//        entityManager.persist(user);
//    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id=: id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void editUser(User updateUser) {

        entityManager.merge(updateUser);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT user from User user").getResultList();
    }
}
