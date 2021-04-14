package pl.olek.niezlababeczka;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.olek.niezlababeczka.entity.*;
import pl.olek.niezlababeczka.repository.*;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ModelTest {

    @Autowired
    EntityManager em;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CakeRepo cakeRepo;
    @Autowired
    SweetRepo sweetRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    LayerTasteRepo layerTasteRepo;
    @Autowired
    PieRepo pieR;
    @Autowired
    PieSizeRepo pieSizeRepo;

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

    @Test
    void shouldSaveSweet(){
        Sweet candy = new Sweet (8.00);
        int a = (int) sweetRepo.count();
        assertThat(sweetRepo.findAll().size()).isEqualTo(a);
    }

    @Test
    void shouldSaveOrder(){
        Sweet lolipop = new Sweet (3.00);
        sweetRepo.save(lolipop);
        Set<SweetOrderItem> lolipops = new HashSet<>();
        SweetOrderItem sweetOrderItem = new SweetOrderItem(80, lolipop);
        lolipops.add(sweetOrderItem);
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        userRepo.save(user);
        Order newOrder = new Order(1L,19828916L, true, true,
                user, null, null, lolipops);
        orderRepo.saveAndFlush(newOrder);

        assertThat(orderRepo.existsById(1L)).isTrue();
    }

    @Test
    void shouldCountOrders(){
        Sweet lolipop = new Sweet (3.00);
        sweetRepo.save(lolipop);
        Set<SweetOrderItem> lolipops = new HashSet<>();
        SweetOrderItem sweetOrderItem = new SweetOrderItem(80, lolipop);
        lolipops.add(sweetOrderItem);
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        userRepo.save(user);
        Order newOrder = new Order(1L,19828916L, true, true,
                user, null, null, lolipops);
        orderRepo.saveAndFlush(newOrder);
        assertThat(orderRepo.getByOrderNumber(19828916L).getSweetOrderItems().size()).isEqualTo(1);
    }

    @Test
    void shouldSaveLayerTaste(){
        LayerTaste lt = new LayerTaste("orange");
        layerTasteRepo.save(lt);
        String orange = "orange";
        assertThat(layerTasteRepo.existsByTaste(orange)).isTrue();
    }

    @Test
    void shouldSavePie(){
        Pie pie = new Pie (99.00, "Apple Pie", "Delicious pie with layer of apple sauce");
        pieR.save(pie);
        assertThat(pieR.existsById(1L));
    }
    @Test
    void shouldSavePieSizeAndCheckIfItIsBlank(){
        PieSize ps = new PieSize("The pie is round with radius = 10cm");
        pieSizeRepo.save(ps);
        assertThat(pieSizeRepo.getOne(1L).getDescription()).isNotBlank();
    }
}
