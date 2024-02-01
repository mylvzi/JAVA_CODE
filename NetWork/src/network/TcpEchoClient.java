package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-02-01
 * Time: 15:44
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int port) throws IOException {
        // 通个这个构造方法 要明确客户端要连接的服务器的位置  即明确服务器的ip和端口号
        // 建立连接的过程是在内核中自动完成的  我们不需要去关注内部的细节
        socket = new Socket(serverIp,port);
    }

    public void start() {
        // 逻辑还是分为四步
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter writer = new PrintWriter(outputStream);
            // 这个对象主要是用于读取服务器的响应  服务器的响应最终是写入到clientSocket对象之中
            // 最终也会传输到用于服务器客户端用于传输的socket对象里
            // 读取数据就是从这个对象之中进行读取
            Scanner scannerNetWork = new Scanner(inputStream);
            while (true) {
                System.out.println("->:");
                // 1.从控制台中获取用户要传输的请求
                String request = scanner.next();
                // 2.将请求传输给服务器
                writer.println(request);
                writer.flush();
                // 3.获取服务器传输过来的响应
                String response = scannerNetWork.next();
                // 4.将响应显示到界面之上
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
