package flowerstore;

import item.Item;

public class RomashkaFlower extends Item {
    @Override
    public double price() {
        return 40;
    }

    @Override
    public String toString() {
        return "romashka";
    }
}
