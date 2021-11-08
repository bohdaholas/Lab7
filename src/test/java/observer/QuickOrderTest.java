package observer;

import delivery.DHLDeliveryStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class QuickOrderTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createOrder() {
        Order tulipsBucket = QuickOrder.Tulip.createOrder(5, new DHLDeliveryStrategy(), new PayPalPaymentStrategy());
        assertEquals(tulipsBucket.itemsToStr().toString(), "[FlowerBucket{flowerPacks=[FlowerPack{flower=Flower(price=10.0, sepalLength=5.0, color=[1, 1, 1], flowerType=TULIP), amount=5}]}]");
        assertEquals(tulipsBucket.calculateTotalPrice(), 50);
    }
}