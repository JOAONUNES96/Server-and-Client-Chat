import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";
        int portNumber = 4041;

        byte[] recvBuffer = new byte[1024];

        DatagramSocket socket = new DatagramSocket(portNumber);

        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);


        String recivedMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println(recivedMessage);


        String newMessage = recivedMessage.toUpperCase();
        byte[] sendBuffer = newMessage.getBytes();


        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                sendBuffer.length, InetAddress.getByName(hostName), 4040);
        socket.send(sendPacket);

        socket.close();
    }
}
