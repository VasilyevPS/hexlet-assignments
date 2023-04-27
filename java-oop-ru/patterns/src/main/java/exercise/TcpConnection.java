package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private int port;
    private String ip;
    private Connection state;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.state = new Disconnected(this);
    }

    void connect() {
        state.connect();
    }

    void disconnect() {
        state.disconnect();
    }

    String getCurrentState() {
        return state.getCurrentState();
    }

    public void setState(Connection connection) {
        state = connection;
    }

    void write(String data) {
        state.write(data);
        if (getCurrentState().equals("connected")) {
            buffer.add(data);
        }
    }

}
// END
