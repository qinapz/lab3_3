package edu.iis.mto.time;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void confirmThrowsOrderExpiredException() {
        Order order = new Order();
        order.submit();
        order.setClock(new FakeClock());
        order.confirm();
    }

}