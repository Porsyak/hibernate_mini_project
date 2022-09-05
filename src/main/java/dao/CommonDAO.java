package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/*
основные операции для всех entity-обьектов
CRUD- Create, Read, Update, Delete
общий поиск данных
 */

public interface CommonDAO<T> {

    // получить одно значение по id
    T get(long id);

    // обновить значения
    void upData(T obj);

    // удалить значение по id
    void delete(long id);

    // добавить значение
    void add(T obj);
}
