package com.bhagyesh.MagentowithJava;



import java.net.MalformedURLException;
import java.util.HashMap;

import redstone.xmlrpc.XmlRpcArray;
import redstone.xmlrpc.XmlRpcClient;
import redstone.xmlrpc.XmlRpcException;
import redstone.xmlrpc.XmlRpcFault;

public class MangentoForJava {
	
	public static void main(String args[]) throws MalformedURLException, XmlRpcException, XmlRpcFault
	{
		XmlRpcClient client=new XmlRpcClient("http://192.168.0.147/magento/index.php/api/xmlrpc/?wsdl",false);
		String sessionId=(String) client.invoke("login", new Object[] {"axelor","123456"});
		
		 HashMap from = new HashMap();
         from.put("from", "201");
         HashMap filters = new HashMap();
         filters.put("created_at", from);
         
         Object [] params = new Object [] {sessionId,"catalog_product.list", new Object [] {filters}};
	     XmlRpcArray orders = (XmlRpcArray)client.invoke("call", params);
	     System.out.println("Data : ---- "+orders.get(0));
	     
	     for (Object object : orders) {
	    	 System.out.println("Data : ---- "+object);
	 	}
	}
}
