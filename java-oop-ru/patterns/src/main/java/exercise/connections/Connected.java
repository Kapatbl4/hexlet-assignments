package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcpConnection;
    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection is already connected.");
    }

    @Override
    public void disconnect() {
        TcpConnection tcp = this.tcpConnection;
        tcp.setCurrentState(new Disconnected(tcp));
    }

    @Override
    public void write(String text) {
        this.tcpConnection.list.add(text);
    }
}
// END
