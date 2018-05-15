package edu.iis.mto.time;

import org.junit.Test;

public class OrderTests {

    private Order order;

    @Test(expected = OrderExpiredException.class)
    public void confirmingShouldThrowOrderExpiredException() {
        order = new Order();
        order.addItem(new OrderItem());
        order.submit();
        order.confirm();
    }

}
