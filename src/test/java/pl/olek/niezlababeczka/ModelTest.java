package pl.olek.niezlababeczka;

import org.junit.jupiter.api.Test;
import pl.olek.niezlababeczka.entity.Order;
import pl.olek.niezlababeczka.entity.OrderItem;
import pl.olek.niezlababeczka.entity.User;

import java.util.Set;

public class ModelTest {

    @Test
    void testModel(){
        Order order = new Order(1213L, true, true, null, null);
        User user = new User("ja", "olo@lo.pl", "fkapa", Set.of(order), "ROLE_ADMIN");

        order.setConfirmed(true);
        order.setOrderNumber(12121L);
        order.getOrderItems(items);
        Set <OrderItem> items = Set.of(new PieOrderItem(), new CakeOrderItem());

    }
}
