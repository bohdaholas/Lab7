package flowerstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter @Setter @ToString
public class Flower {
    private double price;
    private double sepalLength;
    private byte[] color;
    private FlowerType flowerType;

    public void setColor(byte[] color) {
        this.color = Arrays.copyOf(color, color.length);
    }

    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
    }


    public Flower(FlowerType flowerType, double price, double sepalLength, byte[] color) {
        this.flowerType = flowerType;
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
    }
}
