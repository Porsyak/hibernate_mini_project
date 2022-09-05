package dao.interfeses;

import entity.Stat;
import entity.User;

public interface StatDAO {
    Stat getByUser(String email);
    Stat getByUser(User user);
}
