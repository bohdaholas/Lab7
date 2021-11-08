package observer;

import delivery.Delivery;
import item.Item;
import payment.Payment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order implements Observed {

    private final LinkedList<Item> items = new LinkedList<>();
    List<Observer> users = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;

    public LinkedList<Item> getItems() {
        return items;
    }

    public LinkedList<String> itemsToStr() {
        LinkedList<String> itemsStr = new LinkedList<>();
        for (Item item: items) {
            itemsStr.add(item.toString());
        }
        return itemsStr;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.price();
        }
        return price;
    }

    public String processOrder(LinkedList<Item> items) {
        String paymentMSG = payment.pay(calculateTotalPrice());
        String deliveryMSG = delivery.deliver(items);
        return paymentMSG + "\n" + deliveryMSG;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
       items.pop();
    }

    public Payment getPayment() {
        return payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    @Override
    public void addObserver(Observer observer) {
        this.users.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.users.remove(observer);
    }

    @Override
    public String notifyObservers() {
        String msgToObservers = "";
        for (Observer customer : users) {
            msgToObservers += customer.handleEvent(itemsToStr());
        }
        return msgToObservers;
    }
}
