/**
 * 
 */
package com.spring.model;

/**
 * @author Administrator
 *
 */
public class ArcTypeModel {
	
	private String id;
	
	private String typeName;
	
	private String printUrl;
	
	private String goodsName;
	
	private String size;
	
	private String spec;
	
	private String talk;
	
	private String img;
	
	private String num;
	
	private String code;
	
	private String isepq;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	private String year;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPrintUrl() {
		return printUrl;
	}

	public void setPrintUrl(String printUrl) {
		this.printUrl = printUrl;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ArcTypeModel [id=" + id + ", typeName=" + typeName + ", printUrl=" + printUrl + ", goodsName="
				+ goodsName + ", size=" + size + ", spec=" + spec + ", talk=" + talk + ", img=" + img + ", num=" + num
				+ ", code=" + code + ", year=" + year + "]";
	}

	public String getIsepq() {
		return isepq;
	}

	public void setIsepq(String isepq) {
		this.isepq = isepq;
	}
	
	
}
