package designpattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-06-03 23:04
 */
public class DependencyInjectionDemo {

    @Test
    public void testV2() {
        OrderProcessorV2 orderProcessorV2 = new OrderProcessorV2();
        // setter注入
        orderProcessorV2.setOrderService(new MockOrderServiceImpl());
        orderProcessorV2.setEmailService(new MockEmailServiceImpl());
        orderProcessorV2.Process();
    }

    class OrderProcessorV2 {

        private OrderService orderService;

        private EmailService emailService;

        public void setOrderService(OrderService orderService) {
            this.orderService = orderService;
        }

        public void setEmailService(EmailService emailService) {
            this.emailService = emailService;
        }


        public void Process() {
            List<Order> orders = orderService.getOrders();
            for (Order order : orders) {

                OrderEmail email = new OrderEmail();

                emailService.sendMail(email);
            }
        }


    }

    class OrderProcessorV1 {

        public void Process() {
            OrderService orderService = OrderServiceImpl.getInstance();
            EmailService emailService = EmailServiceImpl.getInstance();

            List<Order> orders = orderService.getOrders();
            for (Order order : orders) {

                OrderEmail email = null;

                emailService.sendMail(email);
            }
        }
    }

    static class Order {

    }

    static interface OrderService {

        List<Order> getOrders();
    }

    static interface EmailService {
        void sendMail(OrderEmail email);
    }

    static class OrderServiceImpl implements OrderService {

        private OrderServiceImpl() {
        }

        public List<Order> getOrders() {
            return new ArrayList<>();
        }

        static class InnerClass {
            static final OrderServiceImpl orderService = new OrderServiceImpl();
        }

        public static OrderServiceImpl getInstance() {
            return InnerClass.orderService;
        }
    }

    static class EmailServiceImpl implements EmailService {
        private EmailServiceImpl() {

        }

        public void sendMail(OrderEmail email) {
            System.out.println("send email = " + email);
        }

        static class InnerClass {
            static final EmailServiceImpl emailService = new EmailServiceImpl();
        }

        static EmailServiceImpl getInstance() {
            return InnerClass.emailService;
        }
    }

    private class OrderEmail {
    }

    private class MockOrderServiceImpl implements OrderService {
        @Override
        public List<Order> getOrders() {
            List<Order> orders = new ArrayList<>();
            orders.add(new Order());
            orders.add(new Order());
            orders.add(new Order());
            return orders;
        }
    }

    private class MockEmailServiceImpl implements EmailService {
        @Override
        public void sendMail(OrderEmail email) {
            System.out.println("send email = " + email);
        }
    }
}
