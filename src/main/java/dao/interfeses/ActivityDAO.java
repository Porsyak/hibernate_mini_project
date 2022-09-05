package dao.interfeses;

import dao.CommonDAO;
import entity.Activity;

public interface ActivityDAO extends CommonDAO<Activity> {
    Activity getByUser(String emailUser);
}
