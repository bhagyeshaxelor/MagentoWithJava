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
		
	// Use APi username and Password For Connecting to Magento XMLRPC API	
	XmlRpcClient client=new XmlRpcClient("http://192.168.0.147/magento/index.php/api/xmlrpc/?wsdl",false);
	String sessionId=(String) client.invoke("login", new Object[] {"axelor","123456"});
		
	// Create a hashmap for filter data of sales order 	
	 HashMap from = new HashMap();
         from.put("from", "201");
         HashMap filters = new HashMap();
         filters.put("created_at", from);
         
         // Create Object Array of Parameters and pass to Client Object to call method of API
         Object [] params = new Object [] {sessionId,"sales_order.list", new Object [] {filters}};
	 XmlRpcArray orders = (XmlRpcArray)client.invoke("call", params);
	     
	 for (Object object : orders) {
	    	 System.out.println("Data : ---- "+object);
	 }	
	}
	
}

// ---------------------- Output --------------------------------------//
/* 
Data : ---- {tax_percent=, customer_gender=0, base_adjustment_negative=, is_multi_payment=, discount_refunded=, base_discount_amount=0.0000, billing_address_id=1, base_subtotal_invoiced=, base_shipping_tax_amount=0.0000, quote_id=1, currency_code=, relation_parent_id=, customer_taxvat=, billing_name=bhagyesh h, customer_email=bhagyesh@gmail.com, ext_order_id=, customer_note_notify=0, quote_address_id=, billing_firstname=bhagyesh, postcode=325689, subtotal=2697.9800, order_currency_code=USD, base_tax_amount=0.0000, base_shipping_hidden_tax_amount=0.0000, real_order_id=, base_total_invoiced_cost=, adjustment_positive=, forced_do_shipment_with_invoice=, payment_authorization_expiration=, relation_child_id=, base_shipping_tax_refunded=, can_ship_partially_item=, shipping_hidden_tax_amount=0.0000, base_grand_total=2702.9800, customer_is_guest=0, store_to_order_rate=1.0000, gift_message_id=, increment_id=100000001, base_subtotal_refunded=, base_shipping_discount_amount=0.0000, hidden_tax_invoiced=, base_currency_code=USD, hold_before_status=, base_discount_invoiced=, shipping_discount_amount=0.0000, lastname=h, subtotal_canceled=, original_increment_id=, customer_lastname=h, base_subtotal_canceled=, applied_rule_ids=, tax_canceled=, hold_before_state=, global_currency_code=USD, total_offline_refunded=, custbalance_amount=, forced_shipment_with_invoice=, x_forwarded_for=, relation_parent_real_id=, firstname=bhagyesh, shipping_lastname=h, total_refunded=, ext_customer_id=, discount_canceled=, base_total_online_refunded=, discount_description=, shipping_description=Flat Rate - Fixed, base_hidden_tax_refunded=, shipping_name=bhagyesh h, base_shipping_hidden_tax_amnt=0.0000, total_canceled=, base_total_refunded=, telephone=565656, customer_id=3, customer_group_id=1, customer_middlename=h, edit_increment=, total_invoiced=, base_hidden_tax_amount=0.0000, remote_ip=, base_subtotal_incl_tax=2697.9800, customer_suffix=1, adjustment_negative=, base_custbalance_amount=, subtotal_invoiced=, store_name=Main Website
Main Store
English, grand_total=2702.9800, payment_authorization_amount=, store_currency_code=USD, tax_invoiced=, base_shipping_incl_tax=5.0000, base_hidden_tax_invoiced=, status=pending, billing_lastname=h, store_id=1, relation_child_real_id=, customer_dob=1990-08-18 00:00:00, tracking_numbers=, discount_amount=0.0000, base_tax_refunded=, base_subtotal=2697.9800, base_adjustment_positive=, is_virtual=0, updated_at=2013-07-01 09:11:32, payment_auth_expiration=, shipping_tax_amount=0.0000, protect_code=073a0c, shipping_incl_tax=5.0000, base_tax_invoiced=, tax_refunded=, can_ship_partially=, total_online_refunded=, shipping_invoiced=, total_item_count=1, hidden_tax_amount=0.0000, base_shipping_refunded=, base_total_due=, shipping_method=flatrate_flatrate, weight=14.0000, base_shipping_amount=5.0000, total_qty_ordered=1.0000, shipping_amount=5.0000, subtotal_refunded=, shipping_refunded=, discount_invoiced=, paypal_ipn_customer_notified=, shipping_canceled=, state=new, coupon_rule_name=, currency_rate=, coupon_code=, order_id=1, base_shipping_canceled=, customer_firstname=bhagyesh, shipping_firstname=bhagyesh, currency_base_id=, customer_prefix=Mr., store_to_base_rate=1.0000, subtotal_incl_tax=2697.9800, base_total_invoiced=, base_shipping_invoiced=, tax_amount=0.0000, shipping_address_id=2, is_hold=, created_at=2013-07-01 09:11:32, base_discount_refunded=, base_to_order_rate=1.0000, customer_note=gfdsfg, base_discount_canceled=, total_paid=, base_total_qty_ordered=, hidden_tax_refunded=, shipping_tax_refunded=, base_to_global_rate=1.0000, base_total_offline_refunded=, total_due=, email_sent=1, base_tax_canceled=, base_total_paid=, base_total_canceled=}

*/


