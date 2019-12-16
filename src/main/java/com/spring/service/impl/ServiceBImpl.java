/**
 * 
 */
package com.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.env.Constant;
import com.spring.mapper.MapperB;
import com.spring.model.ArcTypeModel;
import com.spring.service.ServiceB;
import com.spring.utils.QRCodeUtil;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class ServiceBImpl implements ServiceB{

	@Autowired
	MapperB mapperB;
	
//	@Override
//	public void update() {
//		// TODO Auto-generated method stub
//		mapperB.update();
//	}

	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		
		List<ArcTypeModel> list = mapperB.selectAll();
		for (ArcTypeModel arcTypeModel : list) {
			String url = arcTypeModel.getImg();
			Document doc = Jsoup.parse(url);
		      Elements pngs = doc.select("img[src]");
		      for (Element element : pngs) {
		        String imgUrl = element.attr("src");
		        if (imgUrl.trim().startsWith("/")) {
		          imgUrl = Constant.PRINT_URL + imgUrl;
		          element.attr("src", imgUrl);
		        }
		      }
		      url = doc.toString();
		      arcTypeModel.setImg(url);
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> printList() {
		// TODO Auto-generated method stub
		List<ArcTypeModel> list = mapperB.selectAll();
		
		List<ArcTypeModel> x = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			x.addAll((Collection<? extends ArcTypeModel>) handlePrints(list));
		}
		
		return x;
	}

	@Override
	public List<?> printByIds(Long... ids) {
		// TODO Auto-generated method stub
		List<ArcTypeModel> list = mapperB.selectByIds(ids);
		return handlePrints(list);
	}

	@Override
	public List<?> printByPjbh(Long... ids) {
		List<ArcTypeModel> list = mapperB.selectByPjbh(ids);
		return handlePrints(list);
	}

	
	private List<?> handlePrints(List<ArcTypeModel> list){
		for (ArcTypeModel arcTypeModel : list) {
			arcTypeModel.setCode(QRCodeUtil.ImgBase64(arcTypeModel.getPrintUrl(), null));
//			PrintModel model = new PrintModel();
//			model.setTypeName(arcTypeModel.getSpec());
//			model.setPrintUrl();
//			result.add(model);
		}
		return list;
	}



	@Override
	public ArcTypeModel selectOneByNumber(String number) {
		// TODO Auto-generated method stub
		List<ArcTypeModel> list = mapperB.selectOneByNumber(number);
		for (ArcTypeModel arcTypeModel : list) {
			String url = arcTypeModel.getImg();
			Document doc = Jsoup.parse(url);
			Elements pngs = doc.select("img[src]");
			for (Element element : pngs) {
				String imgUrl = element.attr("src");
				if (imgUrl.trim().startsWith("/")) {
					imgUrl = Constant.PRINT_URL + imgUrl;
					element.attr("src", imgUrl);
				}
			}
			url = doc.toString();
			arcTypeModel.setImg(url);
		}
		return list.isEmpty() ? null : list.get(0);
	}
}
