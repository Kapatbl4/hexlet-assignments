package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private Connection currentState = new Disconnected(this);
    private String ip;
    private int port;
    public List<String> list = new ArrayList<>();

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String getCurrentState() {
        return currentState.getCurrentState();
    }

    @Override
    public void connect() {
        currentState.connect();
    }

    @Override
    public void disconnect() {
        currentState.disconnect();
    }

    @Override
    public void write(String text) {
        currentState.write(text);
    }

    public void setCurrentState(Connection state) {
        this.currentState = state;
    }
}
// END
