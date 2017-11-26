/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONObject;

import com.ucpaas.restDemo.client.AbsRestClient;
import com.ucpaas.restDemo.client.JsonReqClient;
import com.ucpaas.restDemo.client.XmlReqClient;

public class RestTest {
	private String accountSid;
	private String authToken;
	
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	static AbsRestClient InstantiationRestAPI(boolean enable) {
		if(enable) {
			return new JsonReqClient();
		} else {
			return new XmlReqClient();
		}
	}

	public static void testTemplateSMS(boolean json,String accountSid,String authToken,String appId,String templateId,String to,String param){
		try {
			String result=InstantiationRestAPI(json).templateSMS(accountSid, authToken, appId, templateId, to, param);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 测试说明 参数顺序，请参照各具体方法参数名称
	 * 参数名称含义，请参考rest api 文档
	 * @author Glan.duanyj
	 * @date 2014-06-30
	 * @param params[]
	 * @return void
	 * @throws IOException 
	 * @method main
	 */
	public static void main(String[] args) throws IOException {
		/*System.out.println("请输入参数，以空格隔开发货...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String param=br.readLine();
		String [] params=param.split(" ");
		String method = params[0];
		System.out.println(method);*/
		int num=new Random().nextInt(10000);
		System.out.println(num);
		boolean json=true;
		/*if (params[1].equals("xml")) {
			json=false;
		}*/
//		if (method.equals("11")) { //短信验证码 
			System.out.println(2222);
			String accountSid="be3b5c9e8591431f9382d35e3e3a48ed";
			String token="a90f2ecfc5dfb0db634cfef43b2dd434";
			String appId="ff51b6a4ac6448e7ae50a64a3dbdbf0b";
			String templateId="171534";
			String to="";
			String para=num+"";
			testTemplateSMS(json, accountSid,token,appId, templateId,to,para);//短信发送接口
//		}
	}
}

