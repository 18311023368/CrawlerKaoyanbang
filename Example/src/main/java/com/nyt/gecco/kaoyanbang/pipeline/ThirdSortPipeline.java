package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.nyt.gecco.kaoyanbang.javabean.DocList;
import org.apache.http.util.TextUtils;

import java.util.ArrayList;
import java.util.List;

@PipelineName("thirdSortPipeline")
public class ThirdSortPipeline implements Pipeline<DocList> {

	public static List<HttpRequest> cateRequests = new ArrayList<HttpRequest>();

	@Override
	public void process(DocList allSort) {
		String cellPhones = allSort.getDocTwoUrl();
		HttpRequest request = allSort.getRequest();
		// 把url保存起来，方便后面开启一个新的引擎进行多线程抓取数据
		if(!TextUtils.isEmpty(cellPhones)){
			System.out.println("地址:"+cellPhones);
			cateRequests.add(request.subRequest(cellPhones));
		}
	}
}
