package observer;

public interface Observed {
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public String notifyObservers();
}
