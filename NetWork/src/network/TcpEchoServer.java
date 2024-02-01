package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-02-01
 * Time: 14:13
 */

/**
 * 重点理解TCP中两个不同的socket对象的作用
 * serversocket是服务器专门用于和客户端建立联系使用的  就是"工具人"
 * socket是用于进行数据交互的
 * 连接的建立是内核中自动完成的 当客户端尝试与服务器进行连接时  TCP会先将建立好的连接对象存储到"阻塞队列"之中
 */
public class TcpEchoServer {
    // 这个socket是专门用于和客户端建立联系的
    private ServerSocket serverSocket = new ServerSocket();

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        // 如果有更多的客户端尝试访问服务器会造成线程大量的创建和销毁 带来一定的开销
        // 使用线程池可以优化一点开销
        // 但实际上也就只能带来一点的优化  还有一种情况并没有考虑到
        // 如果有大量的客户端同一时间访问服务器  计算机并不能同时容纳大量的线程存在
        // 解决方法 I/O多路复用   在java中被包装成了NIO类
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            // 通过服务器socket 把已经在内核中建立好的连接获取到应用程序之中
            // 建立的细节我们不需知道
            // 这里不能直接让主线程执行processConection方法  否则只能有一个客户端能够和服务器进行交互
            // 外层循环是为了建立连接  内层循环是为了进行数据交互
            // 第一个建立连接的客户端最终会在内层循环中阻塞等待 导致其他客户端无法进行连接
            // 此时就需要通过多线程来使内外层循环能够并发执行
            // 把用于进行数据交互的内层循环设置为能够并发执行的状态 -- 多线程
            Socket clientSocket = serverSocket.accept();
//            Thread t=  new Thread(() ->{
//                try {
//                    processConection(clientSocket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            t.start();

            // 使用线程池进行优化
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
    // 通过这个方法处理连接
    private void processConection(Socket clientSocket) throws IOException {
        System.out.printf("[%s : %d] 客户端上线\n",clientSocket.getInetAddress(),clientSocket.getPort());// 打印客户端信息
        // 进行数据交互
        // TCP是面向字节流的  数据的传输是通过字节流对象进行的 通过clientSocket对象来获取对应的字节流对象
        // 使用try () 的方式来自动关闭创建的字节流对象  注意 此处不是关闭clientSocket对象
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();) {

            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()) {
                    // 没有新的数据传入 连接断开  客户端下线
                    System.out.printf("[%s : %d] 客户端下线\n",clientSocket.getInetAddress(),clientSocket.getPort());// 打印客户端信息
                    break;
                }

                // 1.读取请求并解析
                String request = scanner.next();// 读取的时候是以一个'\n'作为一次读取的结束标志
                // 2.根据请求计算响应
                String response = process(request);
                // 3.将响应传输给客户端对象
                // 两种方式: 1.将String对象转化为字节数组  2.使用PrintWriter对象
                // 实际上是将响应写入到clientSocket对象之中
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);// 此处使用println也是为了让客户端读取的时候每次读取到的数据也是以一个'\n'为结束标志
                printWriter.flush();// 不要忘记冲刷缓冲区
                // 4.打印日志
                System.out.printf("[%s : %d] req = %s, res = %s\n",clientSocket.getInetAddress(),clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // clientSocket每次建立连接就会创建
            // 随着客户端的不断增多 clientSocket占用的文件描述符表就会增多 可能会出现文件资源泄露的问题
            // 需要手动进行关闭
            clientSocket.close();
        }
    }

    private String process(String request) {
        // 此处是回显服务器  请求是什么 响应就是什么
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }

}
