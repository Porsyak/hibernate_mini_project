package dao.interfeses;

import dao.CommonDAO;
import dao.FindDAO;
import entity.Task;

import java.util.List;

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {
    // найти все завершенные или не заверщенные задачи по любому пользователю
    List<Task> find(short completed, String email);

}
