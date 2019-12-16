/**
 * 
 */
package com.spring.model;

/**
 * @author Administrator
 *
 */
public class PrintModel {
	
	private String typeName;
	
	private String printUrl;

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

	@Override
	public String toString() {
		return "PrintModel [typeName=" + typeName + ", printUrl=" + printUrl + "]";
	}
	
}
