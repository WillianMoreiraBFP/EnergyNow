package br.com.energynow.Service;

import br.com.energynow.DAO.UserDao;
import br.com.energynow.model.User;

import java.sql.SQLException;

public class UserService {
    UserDao d = new UserDao();

    public User cadastro (User user) throws SQLException {
        d.create(user);
        d.read(user);
        return user;
    }

    public User login (User user) throws SQLException{
       d.read(user);
       return user;
    }

    public void update (User user, String email) throws SQLException{
        d.update(user, email);
    }

    public void delete (User user) throws SQLException{
        d.delete(user);
    }

}
