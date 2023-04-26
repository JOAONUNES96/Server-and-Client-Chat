import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";
        int portNumber = 4040;

        Scanner scanner = new Scanner(System.in);
        String mess = scanner.nextLine();
        byte[] sendBuffer = mess.getBytes();

        DatagramSocket socket = new DatagramSocket(portNumber);

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                sendBuffer.length, InetAddress.getByName(hostName), 4041);
        socket.send(sendPacket);



        byte[] recvBuffer1 = new byte[1024];


        DatagramPacket receivePacket = new DatagramPacket(recvBuffer1, recvBuffer1.length);
        socket.receive(receivePacket);

        String recivedMessage = new String(receivePacket.getData(),0 , receivePacket.getLength());
        System.out.println(recivedMessage);
        socket.close();

    }
}