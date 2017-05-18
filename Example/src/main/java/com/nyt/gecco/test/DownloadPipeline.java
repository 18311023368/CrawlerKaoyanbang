package com.nyt.gecco.test;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.exec.DownloadAction;
import com.nyt.gecco.kaoyanbang.exec.Executors;

import java.net.URLDecoder;

/**
 * Created by nieyutan on 17/5/4.
 */
//@PipelineName("downloadPipeline")
public class DownloadPipeline implements Pipeline<Download> {

    //    @Resource(name = "pictureServiceImpl")
//    private PictureService pictureService;

    //    @Value("${local.path}")

    private Executors executors = Executors.create();
    private String localPath;
    @Override
    public void process(Download bean) {


        String decode = URLDecoder.decode(bean.getDocLastUrl());
        System.out.println(decode);

        int index = decode.lastIndexOf("/");
        String docName = decode.substring(index, decode.length());
        localPath = "/Users/nieyutan/Documents/爬虫/考研帮/"+docName;
//
        executors.getDefaultActionQueue().enqueue(
                new DownloadAction(executors.getDefaultActionQueue(), bean.getDocLastUrl(), localPath));

    }
}
