package com.cong.mySocketServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author linmc
 * @date 2020/10/26
 */
public class SocketServer {


    public static void main(String[] args) throws Exception {

        // 建立服务
        ServerSocket server = new ServerSocket(8080);
        System.out.println("等待sockect连接。。。");
        Socket socket = server.accept(); // accept方法将一直等待连接的到来

        InputStream in = socket.getInputStream();  // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        OutputStream out = socket.getOutputStream();

        // 获取输入
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder msg = new StringBuilder();
        while ((len = in.read(bytes)) != -1) {
            msg.append(new String(bytes, 0, len, "UTF-8"));  //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
        }
        System.out.println("client 信息: " + msg);

        // 输出
        out.write("服务器已接收到信息。。。".getBytes("UTF-8"));


        in.close();
        out.close();
        socket.close();
        server.close();
    }
}