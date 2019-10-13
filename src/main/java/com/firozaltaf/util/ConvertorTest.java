//package com.firozaltaf.util;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import org.apache.http.HttpEntity;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.StringBody;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;
//
//public class ConvertorTest {
//
//	public static void getApiKey() throws ClientProtocolException, IOException {
//		String apiKey = "9e41b975ff0ebf4b10c11576fdbd8cd70529c7d7";
//		String endpoint = "https://sandbox.zamzar.com/v1/formats/gif";
//
//		// Create HTTP client and request object
//		CloseableHttpClient httpClient = getHttpClient(apiKey);
//		HttpGet request = new HttpGet(endpoint);
//
//		// Make request
//		CloseableHttpResponse response = httpClient.execute(request);
//
//		// Extract body from response
//		HttpEntity responseContent = response.getEntity();
//		String result = EntityUtils.toString(responseContent, "UTF-8");
//
//		// Parse result as JSON
//		JSONObject json = new JSONObject(result);
//
//		// Print result
//		System.err.println(json);
//
//		// Finalise response and client
//		response.close();
//		httpClient.close();
//	}
//
//	public static void startConversion(String[] args) throws Exception {
//		String apiKey = "9e41b975ff0ebf4b10c11576fdbd8cd70529c7d7";
//		String endpoint = "https://sandbox.zamzar.com/v1/jobs";
//		String sourceFile = "src/main/resources/building.dwg";
//		String targetFormat = "jpg";
//
//		// Create HTTP client and request object
//		CloseableHttpClient httpClient = getHttpClient(apiKey);
//		HttpEntity requestContent = MultipartEntityBuilder.create()
//				.addPart("source_file", new FileBody(new File(sourceFile)))
//				.addPart("target_format", new StringBody(targetFormat, ContentType.TEXT_PLAIN)).build();
//		HttpPost request = new HttpPost(endpoint);
//		request.setEntity(requestContent);
//
//		// Make request
//		CloseableHttpResponse response = httpClient.execute(request);
//
//		// Extract body from response
//		HttpEntity responseContent = response.getEntity();
//		String result = EntityUtils.toString(responseContent, "UTF-8");
//
//		// Parse result as JSON
//		JSONObject json = new JSONObject(result);
//
//		// Print result
//		System.err.println("========");
//		System.err.println(json);
//
//		// Finalise response and client
//		response.close();
//		httpClient.close();
//	}
//
//	public static void main(String[] args) throws Exception {
//		System.err.println("==========");
//        int fileId = 58210648;
//        String apiKey = "9e41b975ff0ebf4b10c11576fdbd8cd70529c7d7";
//        String endpoint = "https://sandbox.zamzar.com/v1/files/" + fileId + "/content";
//        String localFilename = "src/main/resources/abc.jpg";
//
//        // Create HTTP client and request object
//        CloseableHttpClient httpClient = getHttpClient(apiKey);
//        HttpGet request = new HttpGet(endpoint);
//
//        // Make request
//        CloseableHttpResponse response = httpClient.execute(request);
//
//        // Extract body from response
//        HttpEntity responseContent = response.getEntity();
//
//        // Save response content to file on local disk
//        BufferedInputStream bis = new BufferedInputStream(responseContent.getContent());
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(localFilename));
//        int inByte;
//        while((inByte = bis.read()) != -1) {
//            bos.write(inByte);
//        }
//
//        // Print success message
//        System.err.println("File downloaded");
//
//        // Finalise response, client and streams
//        response.close();
//        httpClient.close();
//        bos.close();
//        bis.close();
//    }
//
//	// Creates a HTTP client object that always makes requests
//	// that are signed with the specified API key via Basic Auth
//	private static CloseableHttpClient getHttpClient(String apiKey) {
//		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(apiKey, ""));
//
//		CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider)
//				.build();
//
//		return httpClient;
//	}
//}
