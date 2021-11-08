package observer;

import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;
import flowerstore.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private RomashkaFlower romashka;
    private CactusFlower cactus;
    private DHLDeliveryStrategy dhl;
    private CreditCardPaymentStrategy creditCard;
    private PayPalPaymentStrategy payPal;
    private PostDeliveryStrategy postDelivery;
    @BeforeEach
    void setUp() {
        order = new Order();
        romashka = new RomashkaFlower();
        cactus = new CactusFlower();
        dhl = new DHLDeliveryStrategy();
        postDelivery = new PostDeliveryStrategy();
        creditCard = new CreditCardPaymentStrategy();
        payPal = new PayPalPaymentStrategy();
    }

    @Test
    void setPayment() {
        order.setPayment(creditCard);
        assertEquals(creditCard, order.getPayment());

        order.setPayment(payPal);
        assertEquals(payPal, order.getPayment());
    }

    @Test
    void setDelivery() {
        order.setDelivery(dhl);
        assertEquals(dhl, order.getDelivery());

        order.setDelivery(postDelivery);
        assertEquals(postDelivery, order.getDelivery());
    }

    @Test
    void calculateTotalPrice() {
        order.addItem(romashka);  // romashka.price = 40
        order.addItem(cactus);  // cactus.price = 12
        assertEquals(52, order.calculateTotalPrice());
    }

    @Test
    void processOrder() {
        order.addItem(romashka);
        order.addItem(cactus);
        order.setPayment(payPal);
        order.setDelivery(postDelivery);
        assertEquals("Paying via Pay pal 52.0 dollars\n" +
                "Delivering via post", order.processOrder(order.getItems()));

    }

    @Test
    void addItem() {
        assertTrue(order.getItems().isEmpty());
        order.addItem(romashka);
        assertEquals(romashka, order.getItems().get(0));
    }

    @Test
    void removeItem() {
        order.addItem(romashka);
        assertEquals(romashka, order.getItems().get(0));
        order.removeItem(romashka);
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    void addObserver() {
        User Peter = new User("Peter");
        order.addObserver(Peter);
        assertNotNull(order.users);
        assertEquals(order.users.get(0), Peter);
    }

    @Test
    void removeObserver() {
        User Peter = new User("Peter");
        order.addObserver(Peter);
        assertFalse(order.users.isEmpty());
        order.removeObserver(Peter);
        assertTrue(order.users.isEmpty());
    }

    @Test
    void notifyObservers() {
        order.addItem(new RomashkaFlower());
        User Peter = new User("Peter");
        assertEquals(order.notifyObservers(), "");
        order.addObserver(Peter);
        assertEquals(order.notifyObservers(), "Hello Peter, there're available the following items: [romashka]");
    }
}