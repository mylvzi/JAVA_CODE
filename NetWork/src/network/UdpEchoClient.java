package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:客户端代码
 * User: 绿字
 * Date: 2024-01-27
 * Time: 23:24
 */
public class UdpEchoClient {

    // 创建出客户端的socket对象  用于和系统api交互
    private DatagramSocket socket = null;
    private String serverIp = "";
    private int serverPort = 0;

    public UdpEchoClient(String ip,int port) throws SocketException {
        // 客户端的端口号由系统随机分配一个空闲的端口号即可
        socket = new DatagramSocket();
        //
        serverIp = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1.尝试从控制台获取"请求"
            System.out.println("-> ");// 提示用户进行输入
            String request = scanner.next();
            // 2.将获取到的"请求"打包为数据报传输给服务器
            // 需要传输:请求的具体内容  要将请求发送到的目的服务器的ip地址和端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),0,request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);// 将数据报传输给服务器
            // 3.尝试接收服务器的响应  响应也是通过数据报进行传输的
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);// 通过客户端的socket来接受服务器的相应
            // 4.把响应转化为字符串并显示出来
            String response = new String(responsePacket.getData(),0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
//        UdpEchoClient client = new UdpEchoClient("154.8.177.175",9090);
        client.start();
    }

}
