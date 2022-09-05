package dao;

import java.util.List;
// различные поиски которые возвращают коллекции

public interface FindDAO<T> {
    // получить абсолютно все значения
    List<T> findAll();

    // получить все значение по почте
    List<T> findAll(String email);

}
