package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection connection;
    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error. Try to connect when connection already established.");
    }

    @Override
    public void disconnect() {
        connection.setState(new Disconnected(connection));
        System.out.println("Disconnected");
    }

    @Override
    public void write(String data) {
        System.out.println("Data '" + data + "' was saved to buffer");
    }
}
// END
