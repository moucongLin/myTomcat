package com.cong.myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author linmc
 * @date 2020/10/27
 */
public class MyTomcat {


    public static void main(String[] args) throws IOException {

        Map<String, String> project ;
        Map<String, String> requestMapping ; //

        ServerSocket server = new ServerSocket(8080);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        Socket socket = server.accept(); // accept方法将一直等待连接的到来


        // 把http请求信息封装成 Request对象，传给servlet的service方法
        InputStream in = socket.getInputStream();  // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder msg = new StringBuilder();
        while ((len = in.read(bytes)) != -1) {
            msg.append(new String(bytes, 0, len, "UTF-8"));  //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
        }
        HttpRequest httpRequest = new HttpRequest(msg.toString());//封装成requst

        //找到对应的servlet
        String url = httpRequest

        System.out.println("client 信息: " + msg);
    }

}
