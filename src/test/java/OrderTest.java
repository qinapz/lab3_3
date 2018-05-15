import edu.iis.mto.time.DateTimeSrc;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;
import edu.iis.mto.time.OrderItem;
import org.junit.Test;

public class OrderTest {
    @Test(expected = OrderExpiredException.class)
    public void confirmingExpiredOrderShouldThrowOrderExpiredException() {
        DateTimeSrc dateTimeSrc = new DateTimeSrc();
        Order order = new Order(dateTimeSrc);
        order.addItem(new OrderItem());

        order.submit();
        dateTimeSrc.setCurrentTimeOffsetMillis(48*60*60*1000);
        order.confirm();
    }
}
