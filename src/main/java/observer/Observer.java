package observer;

import java.util.List;

public interface Observer {
    public String handleEvent(List<String> actions);
}
