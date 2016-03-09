package com.zl.base;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.zl.common.Base64;
import com.zl.common.SystemConf;
import com.zl.enums.EnumResultCode;

import net.sf.json.JSONObject;




@XmlRootElement(name = "returnData")
public class ReturnBean {
	
	private String returnCode = EnumResultCode.SUCCESS.toString();
	private String returnMsg = EnumResultCode.SUCCESS.getValue();
	private String resultCode = EnumResultCode.SUCCESS.toString();
	private String resultMsg;
	
	@XmlElement
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		if(returnCode.equals(EnumResultCode.SUCCESS.toString())){
			this.returnMsg=EnumResultCode.SUCCESS.getValue();
		}else{
			this.returnMsg=EnumResultCode.FAIL.getValue();
		}
		
		this.returnCode = returnCode;
	}
	@XmlElement
	public String getReturnMsg() {
		return returnMsg;
	}
	
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	@XmlElement
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	@XmlElement
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(Map<String, Object> resultMsg) {
		
		JSONObject jb = new JSONObject();
		jb.put("resultData", resultMsg);
		String str=jb.getString("resultData").toString();
		if(SystemConf.getEnvironment().equals("formal")){
			str=Base64.encode(str);
		}
		this.resultMsg = str;
	}
	

	public void getInstace(ReturnBean returnBean){
		if(null!=returnBean)
		returnBean=new ReturnBean();
	}
}
