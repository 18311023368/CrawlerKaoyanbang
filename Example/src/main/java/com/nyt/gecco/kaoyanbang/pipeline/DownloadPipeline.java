package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.javabean.DownloadInfo;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.File;
import java.net.URLDecoder;


/**
 * Created by nieyutan on 17/5/4.
 */
@PipelineName("down")
public class DownloadPipeline implements Pipeline<DownloadInfo> {
    private String fileSavePath="/Users/nieyutan/Documents/爬虫/Demo/Example/file/";

    private String localPath;

    private CloseableHttpClient httpClient;

    {
        RequestConfig clientConfig = RequestConfig.custom().setRedirectsEnabled(false).build();
        PoolingHttpClientConnectionManager syncConnectionManager = new PoolingHttpClientConnectionManager();
        syncConnectionManager.setMaxTotal(1000);
        syncConnectionManager.setDefaultMaxPerRoute(50);
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(clientConfig).setConnectionManager(syncConnectionManager).build();
    }

    @Override
    public void process(DownloadInfo bean) {


        String decode = URLDecoder.decode(bean.getDocLastUrl());
        int index = decode.lastIndexOf("/");
        String docName = decode.substring(index+1, decode.length());
        //文件的后缀名 有时候是pdf有时候的rar
        for (int i = 0; i < CreateFile.filePaths.size(); i++) {
            int d =  CreateFile.filePaths.get(i).lastIndexOf("/");
            String substring =  CreateFile.filePaths.get(i).substring(d+1,  CreateFile.filePaths.get(i).length());
//            System.out.println(docName+"----"+substring);
            if(docName.contains(substring)){
                System.out.println( CreateFile.filePaths.get(i));
                System.out.println( substring);
                System.out.println( docName);

                localPath =  CreateFile.filePaths.get(i)+"/" + docName;
                HttpRequestBase request = new HttpGet(bean.getDocLastUrl());
                try {
                    HttpClientContext context = HttpClientContext.create();
                    org.apache.http.HttpResponse response = httpClient.execute(request, context);
                    FileUtils.copyInputStreamToFile(response.getEntity().getContent(),new File(localPath));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    request.releaseConnection();
                }
                break;
            }
        }

    }



}
