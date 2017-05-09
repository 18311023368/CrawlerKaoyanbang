package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.nyt.gecco.kaoyanbang.javabean.DocList;
import org.apache.http.util.TextUtils;

/**
 * Created by nieyutan on 17/5/2.
 * 读取下一页
// */
@PipelineName("docListPipeline")
public class DocListPipeline implements Pipeline<DocList> {

    public void process(DocList docList) {
        HttpRequest currRequest = docList.getRequest();
        if (TextUtils.isEmpty(docList.getRequest().getUrl())) {
            return;
        }
        if (null != docList.getTotalPage() && docList.getTotalPage().size() > 0) {
            String currPage = docList.getCurrPage();
            //下一页继续抓取
            String nextPage = (Integer.parseInt(currPage) + 1) + "";
            String totalPage = docList.getTotalPage().get(docList.getTotalPage().size() - 2);
            if (Integer.parseInt(nextPage) <= Integer.parseInt(totalPage)) {
                String currUrl = currRequest.getUrl();
                if (currUrl.contains("p" + currPage)) {
                    String newUrl = currUrl.replace("p" + currPage, "");
                    SchedulerContext.into(currRequest.subRequest(newUrl + "p" + nextPage));
                } else {
                    SchedulerContext.into(currRequest.subRequest(currUrl + "p" + nextPage));
                }

            }
        }
//        List<DocDetail> docDetails = docList.getDocName();
//        for (DocDetail docDetail : docDetails) {
//            List<HrefBean> docUrls = docDetail.getDocName();
//            for (HrefBean hrefBean : docUrls) {
//                HttpRequest request = docList.getRequest();
////                // 把url保存起来，方便后面开启一个新的引擎进行多线程抓取数据
//                System.out.println("文档下载地址:"+hrefBean.getUrl());
//                SchedulerContext.into(request.subRequest(hrefBean.getUrl()));
//            }
//
//        }
//





    }
}
