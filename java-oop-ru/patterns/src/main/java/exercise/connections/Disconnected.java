package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection tcp = this.tcpConnection;
        tcp.setCurrentState(new Connected(tcp));
        System.out.println("Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection is already disconnected!");
    }

    @Override
    public void write(String text) {
        System.out.println("Error! No connection found.");
    }

}
// END
