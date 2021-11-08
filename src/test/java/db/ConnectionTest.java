package db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {
    @Test
    void sendRequest() {
        assertEquals(Connection.getConnection().sendRequest("send request 1"), "send request 1");
    }
}