package org.Ioganson.ExSpring;

import org.Ioganson.ExSpring.Util.Util;
import org.Ioganson.ExSpring.model.Item;
import org.Ioganson.ExSpring.model.Person;
import org.hibernate.Session;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class App {
    public static void main(String[] args) throws SQLException {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, 7);
            Item item = new Item("FROM HIB", person);
            person.getItems().add(item);
            session.persist(item);

            session.getTransaction().commit();


        }

    }
}
