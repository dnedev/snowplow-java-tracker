package com.snowplowanalytics.snowplow.tracker;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrackerCTest extends TestCase {

    @Before
    public void setUp() throws Exception {
//        Tracker t1 = new TrackerC("d3rkrsqld9gmqf.cloudfront.net", "com.snowplowanalytics.snowplow.tracker.Tracker Test", "JavaPlow", "com.saggezza", true, true);
////        t1.track();
//        t1.setUserID("User1");
//        t1.setLanguage("ital");
//        t1.setPlatform("mob");
//        t1.setScreenResolution(760, 610);
//        String context = "{'Zone':'USA', 'Phone':'Droid', 'Time':'2pm'}";
//
//        ///// E COMMERCE TEST
//        Map<String,String> items = new HashMap<String, String>();
//        items.put("sku", "SKUVAL"); items.put("quantity","2"); items.put("price","19.99");
//        List<Map<String,String>> lst = new LinkedList<Map<String, String>>();
//        lst.add(items);
//        TrackerC.debug=true;
//
//        /////TRACK TEST
//        for (int i = 0; i < 2; i++) {
//            t1.track();
//            try { Thread.sleep(2000); }
//            catch (InterruptedException e){}
//            System.out.println("Loop " + i);
//            Map<String, Object> dict = new LinkedHashMap<String, Object>();
//            dict.put("Iteration", i);
//            t1.trackUnstructEvent("Lube Insights", "Data Loop", dict, context);
//            t1.trackStructEvent("Items", "Stuff", "Pants", "Green Blue", 3, DEFAULT_VENDOR, context);
//            t1.trackPageView("www.saggezza.com", "Saggezza Home", "KG", null);
//            t1.trackEcommerceTransactionItem("IT1023", "SKUVAL", 29.99, 2, "boots", "Shoes","USD",null,null);
//            t1.trackEcommerceTransaction("OID", 19.99, "Kohls", 2.50, 1.99, "Chagrin", "OH", "USA", "USD", lst, context);
//        }

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTrack_ecommerce_transaction_item() throws Exception {
//        Tracker t1 = new TrackerC("d3rkrsqld9gmqf.cloudfront.net", "com.snowplowanalytics.snowplow.tracker", "JavaPlow", "com.snowplow", true, true);
        Tracker t1 = new TrackerC("segfault.ngrok.com", "com.snowplowanalytics.snowplow.tracker", "JavaPlow", "com.snowplow", true, true);
        t1.setUserID("User1");
        t1.setLanguage("ital");
        t1.setPlatform("mob");
        t1.setScreenResolution(760, 610);
        String context = "{'Zone':'USA', 'Phone':'Droid', 'Time':'2pm'}";
        t1.trackEcommerceTransactionItem("IT1023", "SKUVAL", 29.99, 2, "boots", "Shoes", "USD", null, context);
    }

    @Test
    public void testTrack_ecommerce_transaction_item2() throws Exception {
        Tracker t1 = new TrackerC("segfault.ngrok.com", "com.snowplowanalytics.snowplow.tracker", "JavaPlow", "com.snowplow", true, true);
        t1.setUserID("User1");
        t1.setLanguage("ital");
        t1.setPlatform("mob");
        t1.setScreenResolution(760, 610);
        String context = "{'Zone':'USA', 'Phone':'Droid', 'Time':'2pm'}";
        t1.trackEcommerceTransactionItem("IT1023", "SKUVAL", 29.99, 2, "boots", "Shoes", "USD", null, null);
    }

    @Test
    public void testTrack_ecommerce_transaction() throws Exception {
        Tracker t1 = new TrackerC("segfault.ngrok.com", "com.snowplowanalytics.snowplow.tracker", "JavaPlow", "com.snowplow", true, true);
        t1.setUserID("User1");
        t1.setLanguage("ital");
        t1.setPlatform("mob");
        t1.setScreenResolution(760, 610);
        String context = "{'Zone':'USA', 'Phone':'Droid', 'Time':'2pm'}";

        // TODO: This bit needs to be changed to accept a list of ecomm transaction items
        Map<String,String> items = new HashMap<String, String>();
        items.put("sku", "SKUVAL"); items.put("quantity","2"); items.put("price","19.99");
        List<Map<String,String>> lst = new LinkedList<Map<String, String>>();
        lst.add(items);

        t1.trackEcommerceTransaction("OID", 19.99, "Kohls", 2.50, 1.99, "Chagrin", "OH", "USA", "USD", lst, context);
    }

    @Test
    public void testTrack_unstruct_event() throws Exception {
        Tracker t1 = new TrackerC("segfault.ngrok.com", "com.snowplowanalytics.snowplow.tracker", "JavaPlow", "com.snowplow", true, true);
        t1.setUserID("User1");
        t1.setLanguage("ital");
        t1.setPlatform("mob");
        t1.setScreenResolution(760, 610);
        String context = "{'Zone':'USA', 'Phone':'Droid', 'Time':'2pm'}";

        Map<String, Object> dict = new LinkedHashMap<String, Object>();
        dict.put("Iteration", 1);

        t1.trackUnstructEvent("Lube Insights", "Data Loop", dict, context);
    }
}