package org.Ioganson.ExSpring.Util;


import org.Ioganson.ExSpring.model.Item;
import org.Ioganson.ExSpring.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = getProperties();
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Item.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("SessionFactory created");
        }
        return sessionFactory;
    }

public static Properties getProperties() {
        Properties settings = new Properties();
        settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "a7412369");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put(Environment.HBM2DDL_AUTO, "validate");
        return settings;
}





}
