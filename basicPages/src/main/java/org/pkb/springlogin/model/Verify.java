package org.pkb.springlogin.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Verify {
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LcTHA8UAAAAAA5ELgKjnQ8XxyT0FMCSRAAX-2t1";
	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verifyGcaptchResponse(String gRecaptchaResponse) {
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		try {
			URL obj=new URL(url);
		HttpsURLConnection connection=	(HttpsURLConnection) obj.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setRequestProperty("User-Agent", USER_AGENT);
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		connection.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = connection.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		
		//parse JSON response and return 'success' value
		ObjectMapper mapper=new ObjectMapper();
		
	String jsonValue=	mapper.writeValueAsString(response.toString());
		
		
		return "success".equalsIgnoreCase(jsonValue);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
