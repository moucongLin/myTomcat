package com.cong.mySocketServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author linmc
 * @date 2020/10/26
 */
public class SockectClient {

    public static void main (String[]args)  throws Exception {

        // 建立socket
        Socket socket = new Socket("localhost", 8080); // 连接本地
        socket.setSoTimeout(60000); // 60s超时

        // 建立输入输出流
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // 发送
        String message = "连接测试";
        out.write(message.getBytes("UTF-8"));
        socket.shutdownOutput(); // Socket关闭输出流

        //接受
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder msg = new StringBuilder();
        while ((len = in.read(bytes)) != -1) {
            msg.append(new String(bytes, 0, len,"UTF-8")); //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
        }
        System.out.println("server 信息: " + msg);

        in.close();
        out.close();
        socket.close();

    }

}
