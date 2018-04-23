package edu.iis.mto.time;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    OrderItem orderItem;
    Order order;
    @Before
    public void setUp(){
        order = new Order();
        orderItem = new OrderItem();
        order.addItem( orderItem );

    }
    @Test(expected = OrderExpiredException.class)
    public void testConfirmShouldThrowOrderExpiredException() {
        order.submit();
        order.confirm();
    }

}