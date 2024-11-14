package br.com.energynow.DAO;

import br.com.energynow.model.User;

import java.sql.SQLException;

public interface IUserDao {
    void create (User user) throws SQLException;
    User read (User user) throws SQLException;
    void update (User user, String email) throws SQLException;
    void delete (User user) throws SQLException;

}
