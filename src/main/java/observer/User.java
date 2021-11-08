package observer;

import java.util.List;

public class User implements Observer {
    String name;
    static int userNum = 0;
    private final int id;

    public int getId() {
        return id;
    }

    public User(String name) {
        this.name = name;
        this.id = userNum;
        userNum++;
    }

    @Override
    public String handleEvent(List<String> items) {
        return "Hello " + name + ", there're available the following items: " + items.toString();
    }
}
