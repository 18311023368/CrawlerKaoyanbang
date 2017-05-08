package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.exec.DownloadAction;
import com.nyt.gecco.kaoyanbang.exec.Executors;

import java.net.URLDecoder;

import static com.nyt.gecco.test.CreateFile.filePaths;

/**
 * Created by nieyutan on 17/5/4.
 */
@PipelineName("downloadPipeline")
public class DownloadPipeline implements Pipeline<Download> {

    //    @Resource(name = "pictureServiceImpl")
//    private PictureService pictureService;

    //    @Value("${local.path}")

    private Executors executors = Executors.create();
    private String localPath;
    @Override
    public void process(Download bean) {


        String decode = URLDecoder.decode(bean.getDocLastUrl());
        int index = decode.lastIndexOf("/");
        String docName = decode.substring(index, decode.length());
        //文件的后缀名 有时候是pdf有时候的rar
        for (int i = 0; i < filePaths.size(); i++) {
            int d = filePaths.get(i).lastIndexOf("/");
            String substring = filePaths.get(i).substring(d, filePaths.get(i).length());
            System.out.println(docName+"----"+substring);
            if(docName.contains(substring)){

                 localPath = filePaths.get(i)+"/" + docName;
                executors.getDefaultActionQueue().enqueue(
                        new DownloadAction(executors.getDefaultActionQueue(), bean.getDocLastUrl(), localPath));
            }
        }

    }
}
