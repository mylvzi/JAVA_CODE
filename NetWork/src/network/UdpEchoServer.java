package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:服务器程序代码
 * 这是一个简单的Echo Server  回响服务器  请求是什么 响应就是什么
 * 重点理解服务器客户端交互的逻辑
 * User: 绿字
 * Date: 2024-01-27
 * Time: 23:24
 */

/**
 * 服务器程序编写的核心三步
 *  1.读取请求并解析请求
 *  2.根据请求计算响应
 *  3.将响应返回给客户端
 */
public class UdpEchoServer {
    // 创建一个socket对象进行系统api 的调用
    private DatagramSocket socket = null;

    // 构造方法
    public UdpEchoServer(int port) throws SocketException {
        // 对于客户端和服务器来说 都需要有一个端口号来进行传输
        // 客户端的端口号由用户的系统随机分配即可(如果固定端口 可能导致端口冲突)
        // 服务器的端口号需要程序员 显式指定 只有固定了端口号 才方便用户进行后续的访问
        socket = new DatagramSocket(port);

        // 下面这种方式就是通过系统自动分配一个端口号
//        socket = new DatagramSocket();
    }

    // 开启服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");

        while (true) {
            // 1.接受请求 并对请求进行解析  请求是通过数据报的格式传输过来的
            // DatagramPacket不会自动分配内存  需要程序员手动设置内存大小
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);// 创建数据包来接受请求
            socket.receive(requestPacket);// 服务器接收请求  如果没接收到请求 就会阻塞等待

            // 数据报中的数据都是二进制形式的  如果要查看 需要将其转化为字符串格式 参数1:数据报中的有效数据(载荷)
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());

            // 2.根据请求做出响应 通过process方法进行响应  这里的响应比较简单 请求是什么 就响应什么
            String response = process(request);

            // 3.将服务器的相应传输给客户端
            // 将要传输的数据response打包为一个数据报 数据报中要包含要传输的内容(具体内容+长度),还有应该发送的地址(哪里发的请求就把响应发送给哪里)
            // 传输过程中要使用二进制数据  首先将response转化为一个字节数组
            // 通过getSocketAddress方法获得请求部分的socket 的地址
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);// 发送响应

            // 4.打印日志  将这次交互的信息完整的打印出来
            // 客户端的ip  端口号  请求内容  响应内容
            System.out.printf("[%s : %d] req = %s, resp = %s\n",requestPacket.getAddress().toString(),
                    responsePacket.getPort(),request,response);
        }

    }

    public String process(String request) {
        return request;
    }


    public static void main(String[] args) throws IOException {

        // 手动指定一个端口号 可以随意指定  但不能是知名端口号
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
