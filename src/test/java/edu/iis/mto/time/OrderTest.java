package edu.iis.mto.time;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void confirmWithExpiredOrderShouldThrowOrderExpiredException() {
        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        order.setDateTimeSource(GenericDateTimeSource.getInstance());
        order.addItem(orderItem);

        order.getDateTimeSource().forwardTime(25);

        order.submit();
        order.confirm();
    }

}