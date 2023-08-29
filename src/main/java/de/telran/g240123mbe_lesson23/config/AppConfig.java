package de.telran.g240123mbe_lesson23.config;

import de.telran.g240123mbe_lesson23.database.CommonDataBase;
import de.telran.g240123mbe_lesson23.database.DataBase;
import de.telran.g240123mbe_lesson23.repository.Repository;
import de.telran.g240123mbe_lesson23.repository.UserRepository;
import de.telran.g240123mbe_lesson23.service.PasswordService;
import de.telran.g240123mbe_lesson23.service.SimplePasswordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataBase dataBase() {
        return new CommonDataBase();
    }

    @Bean
    public Repository repository() {
        return new UserRepository();
    }

    @Bean
    public PasswordService passwordService() {
        return new SimplePasswordService();
    }
}
