package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

/**
 * Created by nieyutan on 17/5/8.
 */
@PipelineName("unamePipeline")
public class UnamePipeline implements Pipeline<UnName> {
    @Override
    public void process(UnName unName) {
//        UnNameDetail docName = unName.getDocName();
//        System.out.println("二级目录:"+docName.getDocName());
//        TypeDetail typeDetails = unName.getTypeDetails();
//        System.out.println("二级文件"+typeDetails.getDocName());

    }
}
