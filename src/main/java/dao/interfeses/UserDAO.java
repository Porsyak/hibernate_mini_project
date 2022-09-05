package dao.interfeses;

import dao.CommonDAO;
import dao.FindDAO;
import entity.User;

public interface UserDAO extends CommonDAO<User>, FindDAO<User> {
    User getByEmail(String emailUser);
}
