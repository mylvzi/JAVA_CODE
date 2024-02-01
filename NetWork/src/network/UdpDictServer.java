package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:词典服务器
 * User: 绿字
 * Date: 2024-01-28
 * Time: 16:26
 */
public class UdpDictServer extends UdpEchoServer{
    // "翻译"的过程实际上就是一个查表的过程  提前在一个容器中存储映射关系
    Map<String,String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("cat","猫");
        dict.put("dog","狗");
        dict.put("mouse","鼠");
    }

    @Override
    public String process(String request) {
        // 通过重写"根据请求计算响应"这部分的逻辑来实现翻译工作
        return dict.getOrDefault(request,"词典中不包含该词!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer dictServer = new UdpDictServer(9090);
        dictServer.start();
    }
}
