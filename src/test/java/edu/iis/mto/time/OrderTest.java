package edu.iis.mto.time;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
    private Order order;
    private OrderItem orderItem;

    @Test(expected = OrderExpiredException.class)
    public void confirmWithExpiredOrderShouldThrowOrderExpiredException() {
        order = new Order();
        orderItem = new OrderItem();

        order.setDateTimeSource(GenericDateTimeSource.getInstance());
        order.addItem(orderItem);

        order.getDateTimeSource().forwardTime(26);

        order.submit();
        order.confirm();
    }

}