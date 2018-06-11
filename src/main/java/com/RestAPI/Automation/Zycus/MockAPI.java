package com.RestAPI.Automation.Zycus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HandshakeCompletedEvent;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("deprecation")
public class MockAPI {

private final String USER_AGENT="Mozilla/5.0";
public String inline = "";
public HttpPost postrequest;
public HttpGet getrequest;
public HttpResponse response;

public  String GetResponse(String url, String requesttype) throws ClientProtocolException, IOException
{
	StringBuffer result=new StringBuffer();
	HttpClient client=new DefaultHttpClient();
	
	URL ourl = new URL(url);
	
	if (requesttype.contains("POST"))
	{
		 postrequest = new HttpPost(url);
		 postrequest.addHeader("User-Agent",USER_AGENT);
		 response=client.execute(postrequest);
	}
	else if (requesttype.contains("GET"))
	{
		 getrequest=new HttpGet(url);
		 getrequest.addHeader("User-Agent",USER_AGENT);
		 response=client.execute(getrequest);
	}
	
	
	int responseCode=response.getStatusLine().getStatusCode();
	System.out.println("Response Code: " + responseCode);
	
	HashMap<Integer, String> responseCodeInfo = new HashMap<Integer, String>();
		
	responseCodeInfo.put(100, "Continue");
			
	responseCodeInfo.put(101, "Switching Protocols");
			
	responseCodeInfo.put(102, "Processing (WebDAV; RFC 2518)");
			
	responseCodeInfo.put(103, "Early Hints (RFC 8297)");
			
	responseCodeInfo.put(200, "OK");
			
	responseCodeInfo.put(201, "Created");
			
	responseCodeInfo.put(202, "Accepted");
			
	responseCodeInfo.put(203, "Non-Authoritative Information (since HTTP/1.1)");
			
	responseCodeInfo.put(204, "No Content");
			
	responseCodeInfo.put(205, "Reset Content");
			
	responseCodeInfo.put(206, "Partial Content (RFC 7233)");
			
	responseCodeInfo.put(207, "Multi-Status (WebDAV; RFC 4918)");
			
	responseCodeInfo.put(208, "Already Reported (WebDAV; RFC 5842)");
			
	responseCodeInfo.put(226, "IM Used (RFC 3229)");
			
	responseCodeInfo.put(300, "Multiple Choices");
			
	responseCodeInfo.put(301, "Moved Permanently");
			
	responseCodeInfo.put(302, "Found");
			
	responseCodeInfo.put(303, "See Other (since HTTP/1.1)");
			
	responseCodeInfo.put(304, "Not Modified (RFC 7232)");
			
	responseCodeInfo.put(305, "Use Proxy (since HTTP/1.1)");
			
	responseCodeInfo.put(306, "Switch Proxy");
			
	responseCodeInfo.put(307, "Temporary Redirect (since HTTP/1.1)");
			
	responseCodeInfo.put(308, "Permanent Redirect (RFC 7538)");
			
	responseCodeInfo.put(404, "error on Wikipedia");
			
	responseCodeInfo.put(400, "Bad Request");
			
	responseCodeInfo.put(401, "Unauthorized (RFC 7235)");
			
	responseCodeInfo.put(402, "Payment Required");
			
	responseCodeInfo.put(403, "Forbidden");
			
	responseCodeInfo.put(404, "Not Found");
			
	responseCodeInfo.put(405, "Method Not Allowed");
			
	responseCodeInfo.put(406, "Not Acceptable");
			
	responseCodeInfo.put(407, "Proxy Authentication Required (RFC 7235)");
			
	responseCodeInfo.put(408, "Request Timeout");
			
	responseCodeInfo.put(409, "Conflict");
			
	responseCodeInfo.put(410, "Gone");
			
	responseCodeInfo.put(411, "Length Required");
			
	responseCodeInfo.put(412, "Precondition Failed (RFC 7232)");
			
	responseCodeInfo.put(413, "Payload Too Large (RFC 7231)");
			
	responseCodeInfo.put(414, "URI Too Long (RFC 7231)");
			
	responseCodeInfo.put(415, "Unsupported Media Type");
			
	responseCodeInfo.put(416, "Range Not Satisfiable (RFC 7233)");
			
	responseCodeInfo.put(417, "Expectation Failed");
			
	responseCodeInfo.put(418, "I'm a teapot (RFC 2324, RFC 7168)");
			
	responseCodeInfo.put(421, "Misdirected Request (RFC 7540)");
			
	responseCodeInfo.put(422, "Unprocessable Entity (WebDAV; RFC 4918)");
			
	responseCodeInfo.put(423, "Locked (WebDAV; RFC 4918)");
			
	responseCodeInfo.put(424, "Failed Dependency (WebDAV; RFC 4918)");
			
	responseCodeInfo.put(426, "Upgrade Required");
			
	responseCodeInfo.put(428, "Precondition Required (RFC 6585)");
			
	responseCodeInfo.put(429, "Too Many Requests (RFC 6585)");
			
	responseCodeInfo.put(431, "Request Header Fields Too Large (RFC 6585)");
			
	responseCodeInfo.put(451, "Unavailable For Legal Reasons (RFC 7725)");
				
	responseCodeInfo.put(500, "Internal Server Error");
			
	responseCodeInfo.put(501, "Not Implemented");
			
	responseCodeInfo.put(502, "Bad Gateway");
			
	responseCodeInfo.put(503, "Service Unavailable");
			
	responseCodeInfo.put(504, "Gateway Timeout");
			
	responseCodeInfo.put(505, "HTTP Version Not Supported");
			
	responseCodeInfo.put(506, "Variant Also Negotiates (RFC 2295)");
			
	responseCodeInfo.put(507, "Insufficient Storage (WebDAV; RFC 4918)");
			
	responseCodeInfo.put(508, "Loop Detected (WebDAV; RFC 5842)");
			
	responseCodeInfo.put(510, "Not Extended (RFC 2774)");
			
	responseCodeInfo.put(511, "Network Authentication Required (RFC 6585)");

	try{
		
		if(responseCodeInfo.containsKey(responseCode))
		
		{
			System.out.println(responseCode+" - "+responseCodeInfo.get(responseCode));
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line="";
		
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println(result.toString());
			}
		
			Scanner sc = new Scanner(ourl.openStream());
		
			while(sc.hasNext())
			{
				inline += sc.nextLine();
			}
					
			System.out.println("\nJSON data in string format");
					
			System.out.println(inline);
					
			sc.close();
		
			//code to handle and print Json response
			
			//if(responseCodeInfo.containsKey(200))
				
			//{
				
			//JSONParser parse = new JSONParser();
				
			//JSONObject jobj = (JSONObject)parse.parse(inline);
				
			//JSONArray jsonarr_1 = (JSONArray)jobj.get("results");
				
			//for(int i = 0; i<((Map<Integer, String>) jsonarr_1).size(); i++)
				//{
				//	JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
						
				//	System.out.println("Elements under results array");
						
						//System.out.println(jsonobj_1.get("KeyName"));
				//}
			//}
		}
		
		return result.toString();
		
	}
	catch(Exception ex)
	{
		responseCodeInfo.putIfAbsent(responseCode, "False");

		if( responseCodeInfo.containsValue("False") && !(response.containsHeader("exception")))
		{
			System.out.println("Response Failed, Unable to recognize response code");
			result.append("Response Failed");
			
		}
		else if(response.containsHeader("exception"))
		{
			System.out.println("Exception - "+response);
		}
		return result.toString();
		
		}
	}
}
