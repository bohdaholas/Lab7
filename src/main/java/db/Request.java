package db;

public class Request {
    public static void main(String[] args) {
        Connection.getConnection().sendRequest("First");
        Connection.getConnection().sendRequest("Second");
    }
}
