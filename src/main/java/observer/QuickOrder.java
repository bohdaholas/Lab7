package observer;

import delivery.Delivery;
import flowerstore.Flower;
import flowerstore.FlowerBucket;
import flowerstore.FlowerPack;
import flowerstore.FlowerType;
import payment.Payment;

public enum QuickOrder {
    Tulip(new Flower(FlowerType.TULIP, 10, 5, new byte[]{1, 1, 1})),
    Rose(new Flower(FlowerType.ROSE, 96, 3, new byte[]{5, 5, 5})),
    Chamomile(new Flower(FlowerType.CHAMOMILE, 20, 4, new byte[]{3, 3, 3}));

    private final Flower flower;

    QuickOrder(Flower flower) {
        this.flower = flower;
    }

    public Order createOrder(int amount, Delivery delivery, Payment payment) {
        FlowerBucket flowerBucket = new FlowerBucket();
        FlowerPack flowerPack = new FlowerPack();
        flowerPack.setFlower(flower);
        flowerPack.setAmount(amount);
        flowerBucket.addFlowerPack(flowerPack);

        Order order = new Order();
        order.setDelivery(delivery);
        order.setPayment(payment);
        order.addItem(flowerBucket);

        return order;
    }
}
