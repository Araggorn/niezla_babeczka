package pl.olek.niezlababeczka;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.olek.niezlababeczka.entity.*;
import pl.olek.niezlababeczka.repository.*;

import javax.persistence.EntityManager;
import java.util.*;

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
    void shouldLoadContext() {

    }

    //zbudować model użytkownika, orderów itd...

    @Test
    void shouldSaveUser() {
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        user.setId(UUID.randomUUID());
        userRepo.saveAndFlush(user);


        assertThat(userRepo.existsByLogin("Kuba")).isTrue();
        assertThat(userRepo.getByLogin("Kuba").getMail()).isEqualTo("qbeczek@o2.pl");
    }

    @Test
    void shouldSaveCake() {
        Cake cake = new Cake(170.99, 12.0);
        cake.setId(UUID.randomUUID());
        cakeRepo.saveAndFlush(cake);
        assertThat(cakeRepo.findAll()).contains(cake);
    }

    @Test
    void shouldSaveSweet() {
        Sweet candy = new Sweet(8.00, "candy");
        int a = (int) sweetRepo.count();
        assertThat(sweetRepo.findAll().size()).isEqualTo(a);
    }

    @Test
    void shouldSaveOrder() {
        Sweet lolipop = new Sweet(3.00, "lolipop");
        lolipop.setId(UUID.randomUUID());
        sweetRepo.save(lolipop);
        Set<SweetOrderItem> lolipops = new HashSet<>();
        SweetOrderItem sweetOrderItem = new SweetOrderItem(80, lolipop);
        sweetOrderItem.setId(UUID.randomUUID());
        lolipops.add(sweetOrderItem);
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        user.setId(UUID.randomUUID());
        userRepo.save(user);
        Order newOrder = new Order(19828916L, true, true,
                user, null, null, lolipops);
        newOrder.setId(UUID.randomUUID());
        orderRepo.saveAndFlush(newOrder);

        assertThat(orderRepo.existsById(newOrder.getId())).isTrue();
    }

    @Test
    void shouldCountOrders() {
        Sweet lolipop = new Sweet(3.00, "lolipop");
        lolipop.setId(UUID.randomUUID());
        sweetRepo.save(lolipop);
        Set<SweetOrderItem> lolipops = new HashSet<>();
        SweetOrderItem sweetOrderItem = new SweetOrderItem(80, lolipop);
        sweetOrderItem.setId(UUID.randomUUID());
        lolipops.add(sweetOrderItem);
        User user = new User("Kuba", "qbeczek@o2.pl", "aaa", new HashSet<>(), "ROLE_ADMIN");
        user.setId(UUID.randomUUID());
        userRepo.save(user);
        Order newOrder = new Order( 19828916L, true, true,
                user, null, null, lolipops);
        newOrder.setId(UUID.randomUUID());

        orderRepo.saveAndFlush(newOrder);
        assertThat(orderRepo.existsById(newOrder.getId())).isTrue();
        assertThat(orderRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    void shouldSaveLayerTaste() {
        LayerTaste lt = new LayerTaste("orange");
        lt.setId(UUID.randomUUID());
        layerTasteRepo.save(lt);
        String orange = "orange";
        assertThat(layerTasteRepo.existsByTaste(orange)).isTrue();
    }

    @Test
    void shouldSavePie() {
        Pie pie = new Pie(99.00, "Apple Pie", "Delicious pie with layer of apple sauce");
        pie.setId(UUID.randomUUID());
        pieR.save(pie);
        assertThat(pieR.existsById(pie.getId())).isTrue();
    }

    @Test
    void shouldSavePieSizeAndCheckIfItIsBlank() {
        PieSize ps = new PieSize("The pie is round with radius = 10cm");
        ps.setId(UUID.randomUUID());
        pieSizeRepo.save(ps);
        assertThat(pieSizeRepo.getById(ps.getId()).getDescription()).isNotBlank();
    }

    @Test
    void shouldSaveComplexOrder() {
        User user = new User("Olek", "olek@olek.pl", "olo", new LinkedHashSet<>(), "ROLE_USER");
        user.setId(UUID.randomUUID());
        userRepo.saveAndFlush(user);

        Sweet candy = new Sweet(9.00, "candy");
        candy.setId(UUID.randomUUID());
        sweetRepo.save(candy);

        Sweet loli = new Sweet(5.00, "lolipops");
        loli.setId(UUID.randomUUID());
        sweetRepo.save(loli);

        SweetOrderItem lolipops = new SweetOrderItem(10, loli);
        lolipops.setId(UUID.randomUUID());

        SweetOrderItem candies = new SweetOrderItem(50, candy);
        candies.setId(UUID.randomUUID());

        Set<SweetOrderItem> sweets = new HashSet<>();
        sweets.add(lolipops);
        sweets.add(candies);

        Cake cake = new Cake(160.00, 16.0);
       cake.setId(UUID.randomUUID());
        cakeRepo.saveAndFlush(cake);

        LayerTaste lt = new LayerTaste("orange");
       lt.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt);

        LayerTaste lt2 = new LayerTaste("nuts");
        lt2.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt2);

        LayerTaste lt3 = new LayerTaste("chocolate");
        lt3.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt3);

        CakeOrderItem cakeOrderItem = new CakeOrderItem();
        cakeOrderItem.setId(UUID.randomUUID());
        CakeLayer cakeLayer1 = new CakeLayer(cakeOrderItem, lt);
        CakeLayer cakeLayer2 = new CakeLayer(cakeOrderItem, lt2);
        CakeLayer cakeLayer3 = new CakeLayer(cakeOrderItem, lt3);
        cakeOrderItem.setCake(cake);

        Pie pie = new Pie(100.00, "cheesecake", "it's not a pie, but for this purpose it is");
       pie.setId(UUID.randomUUID());
        pieR.saveAndFlush(pie);

        PieSize pieSize = new PieSize("big: 40cm * 30cm");
       pieSize.setId(UUID.randomUUID());
        pieSizeRepo.saveAndFlush(pieSize);

        PieSize pieSize2 = new PieSize("small: 30cm * 20cm");
        pieSize2.setId(UUID.randomUUID());
        pieSizeRepo.saveAndFlush(pieSize2);

        Pie pie2 = new Pie(125.00, "apple pie", "it's delicious pie");
        pie2.setId(UUID.randomUUID());
        pieR.saveAndFlush(pie2);

        PieOrderItem pieOrderItem = new PieOrderItem(pieSize2, pie);
        pieOrderItem.setId(UUID.randomUUID());

        PieOrderItem pieOrderItem1 = new PieOrderItem(pieSize, pie2);
        pieOrderItem1.setId(UUID.randomUUID());

        Set<PieOrderItem> pieList = Set.of(pieOrderItem, pieOrderItem1);

        //making an order;
        Order order = new Order(UUID.randomUUID(), 1234L, false, false, user,
                Collections.singleton(cakeOrderItem), pieList, sweets);
        order.setId(UUID.randomUUID());
        orderRepo.saveAndFlush(order);

        List<Order> orders = orderRepo.findAll();

        assertThat(orderRepo.existsById(order.getId())).isTrue();

    }

    @Test
    void shouldSaveMoreThanOneSweets() {
        User user = new User("Olek", "olek@olek.pl", "olo", new LinkedHashSet<>(), "ROLE_USER");
        user.setId(UUID.randomUUID());
        userRepo.saveAndFlush(user);
        Sweet candy = new Sweet(9.00, "strawberry candy");
        candy.setId(UUID.randomUUID());
        sweetRepo.save(candy);
        Sweet loli = new Sweet(5.00, "strawberry lolipops");
        loli.setId(UUID.randomUUID());
        sweetRepo.save(loli);
        SweetOrderItem lolipops = new SweetOrderItem(10, loli);
        lolipops.setId(UUID.randomUUID());
        SweetOrderItem candies = new SweetOrderItem(50, candy);
        candies.setId(UUID.randomUUID());
        Set<SweetOrderItem> sweets = new HashSet<>();
        sweets.add(lolipops);
        sweets.add(candies);
        Order order = new Order(222L, false, false, user, new HashSet<>(), new HashSet<>(), sweets);
        order.setId(UUID.randomUUID());
        orderRepo.saveAndFlush(order);

        assertThat(orderRepo.existsById(order.getId())).isTrue();
    }

    @Test
    void shouldUseOnePieSizeInTwoPieOrderItems() {
        User user = new User("Olek", "olek@olek.pl", "olo", new LinkedHashSet<>(), "ROLE_USER");
        user.setId(UUID.randomUUID());
        userRepo.saveAndFlush(user);
        Pie pie = new Pie(150.00, "cheesecake", "it's not a pie, but for this purpose it is");
        pie.setId(UUID.randomUUID());
        pieR.saveAndFlush(pie);
        PieSize pieSize = new PieSize("big: 40cm * 30cm");
        pieSize.setId(UUID.randomUUID());
        pieSizeRepo.saveAndFlush(pieSize);
        Pie pie2 = new Pie(125.00, "apple pie", "it's delicious pie");
        pie2.setId(UUID.randomUUID());
        pieR.saveAndFlush(pie2);
        PieOrderItem pieOrderItem = new PieOrderItem(pieSize, pie);
        pieOrderItem.setId(UUID.randomUUID());
        PieOrderItem pieOrderItem1 = new PieOrderItem(pieSize, pie2);
        pieOrderItem1.setId(UUID.randomUUID());
        Set<PieOrderItem> pieList = Set.of(pieOrderItem, pieOrderItem1);

        Order order = new Order(UUID.randomUUID(), 223L, false, false,
                user, new HashSet<>(), pieList, new HashSet<>());
        order.setId(UUID.randomUUID());
        orderRepo.saveAndFlush(order);

        assertThat(orderRepo.existsById(order.getId())).isTrue();

    }

    @Test
    void shouldSaveLayerTaste2() {
        LayerTaste layerTaste = new LayerTaste("mango");
        layerTaste.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(layerTaste);

        assertThat(layerTasteRepo.existsByTaste("mango")).isTrue();

    }

    @Test
    void shouldSaveTwoDifferentCakes() {
        Cake cake = new Cake (1000.00, 40.6);
        Cake cake2 = new Cake (280.00, 15.0);
        cake.setId(UUID.randomUUID());
        cake2.setId(UUID.randomUUID());
        cakeRepo.saveAndFlush(cake);
        cakeRepo.saveAndFlush(cake2);

        LayerTaste lt1 = new LayerTaste("strawberry");
        lt1.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt1);
        LayerTaste lt2 = new LayerTaste("chocolate");
        lt2.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt2);
        LayerTaste lt3 = new LayerTaste("raspberry");
        lt3.setId(UUID.randomUUID());
        layerTasteRepo.saveAndFlush(lt3);


        CakeLayer cl1 = new CakeLayer(lt1);
        cl1.setId(UUID.randomUUID());
        CakeLayer cl2 = new CakeLayer(lt2);
        cl2.setId(UUID.randomUUID());
        CakeLayer cl3 = new CakeLayer(lt3);
        cl3.setId(UUID.randomUUID());

        Set<CakeLayer> cakeLayerSet = Set.of(cl1,cl2,cl3);

        CakeOrderItem cakeOrderItem = new CakeOrderItem(20, cakeLayerSet, cake);
        cakeOrderItem.setId(UUID.randomUUID());
        CakeOrderItem cakeOrderItem2 = new CakeOrderItem(16, cakeLayerSet, cake2);
        cakeOrderItem2.setId(UUID.randomUUID());

        Set<CakeOrderItem> cakeOrderItems = new HashSet<>();
        cakeOrderItems.add(cakeOrderItem);
        cakeOrderItems.add(cakeOrderItem2);


        User user = new User("Olek", "olek@olek.pl", "olo", new LinkedHashSet<>(), "ROLE_USER");
        user.setId(UUID.randomUUID());
        userRepo.saveAndFlush(user);

        Order order = new Order(UUID.randomUUID(), 223L, false, false,
                user, cakeOrderItems, new HashSet<>(), new HashSet<>());
        order.setId(UUID.randomUUID());
        orderRepo.saveAndFlush(order);

        assertThat(orderRepo.existsById(order.getId())).isTrue();

    }
}
