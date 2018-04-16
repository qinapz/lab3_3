package edu.iis.mto.time;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class OrderTest {

    @Test(expected = OrderExpiredException.class)
    public void confirmThrowsOrderExpiredException() {
        Order order = new Order();
        order.submit();

        try {
            Class<?> orderClass = order.getClass();
            Field clockField = orderClass.getDeclaredField("clock");
            clockField.setAccessible(true);
            clockField.set(order, new FakeClock());
        } catch (NoSuchFieldException exception) {
            exception.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        order.confirm();
    }

}