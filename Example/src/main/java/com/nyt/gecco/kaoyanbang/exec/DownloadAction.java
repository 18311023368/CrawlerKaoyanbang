package com.nyt.gecco.kaoyanbang.exec;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/4/9/009.
 */
public class DownloadAction extends Action {

    private String url;
    private String localPath;

    public DownloadAction(ActionQueue queue, String url, String localPath) {
        super(queue);
        this.url = url;
        this.localPath = localPath;
    }

    @Override
    protected void execute() {
        try {
            URL realUrl = new URL(this.url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream in = connection.getInputStream();
            OutputStream out = new FileOutputStream(this.localPath);
            int length;
            byte[] bytes = new byte[2046];
            while ((length = in.read(bytes)) != -1){
                out.write(bytes,0,length);
                out.flush();
            }
            out.close();
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
