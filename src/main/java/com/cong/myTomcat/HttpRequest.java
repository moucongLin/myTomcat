package com.cong.myTomcat;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author linmc
 * @date 2020/10/27
 */
public class HttpRequest {


    private String method;

    private String url;

    private String content;

    private Map<String, Object> attributes = new HashMap<String, Object>();

    // 构造方法，将http的信息封装成requset对象
    //Get请求例子
    //GET /562f25980001b1b106000338.jpg HTTP/1.1
    //Host    img.mukewang.com
    //User-Agent    Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36
    //Accept    image/webp,image/*,*/*;q=0.8
    //Referer    http://www.imooc.com/
    //Accept-Encoding    gzip, deflate, sdch
    //Accept-Language    zh-CN,zh;q=0.8
    //
    //POST请求例子：
    //POST / HTTP1.1
    //Host:www.wrox.com
    //User-Agent:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022)
    //Content-Type:application/x-www-form-urlencoded
    //Content-Length:40
    //Connection: Keep-Alive
    //
    //name=Professional%20Ajax&publisher=Wiley
    public HttpRequest(String httpMessage) {
        String[] rows = httpMessage.split("\r\n"); //分行
        String firstLine = rows[0]; //第一行
        method = firstLine.split(" ")[0]; // 请求方法
        url = firstLine.split(" ")[1]; //请求url
//        String projectName = firstLine.split(" ")[1].split("/")[1];  //请求的项目
//        String servletPath = firstLine.split(" ")[1].replace("/"+projectName, "");  //请求路径

        //如果是post请求，则有请求数据
        content = rows[rows.length-1];
    }

}
