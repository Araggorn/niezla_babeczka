package pl.olek.niezlababeczka;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.olek.niezlababeczka.entity.Cake;
import pl.olek.niezlababeczka.entity.User;
import pl.olek.niezlababeczka.repository.CakeRepo;
import pl.olek.niezlababeczka.repository.UserRepo;

import javax.persistence.EntityManager;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ModelTest {

    @Autowired
    EntityManager em;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CakeRepo cakeRepo;

    @Test
    void shouldLoadContext(){

    }

    //zbudować model użytkownika, orderów itd...

    @Test
    void shouldSaveUser(){
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        userRepo.saveAndFlush(user);


        assertThat(userRepo.existsByLogin("Kuba")).isTrue();
        assertThat(userRepo.getByLogin("Kuba").getMail()).isEqualTo("qbeczek@o2.pl");
    }

    @Test
    void shouldSaveCake(){
        Cake cake = new Cake(170.99 , 12.0);
        cakeRepo.saveAndFlush(cake);
        assertThat(cakeRepo.findAll().contains(cake));
    }


}
