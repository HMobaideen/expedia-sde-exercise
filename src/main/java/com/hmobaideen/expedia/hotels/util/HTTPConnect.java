package com.hmobaideen.expedia.hotels.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * <h1>HTTPConnect class</h1> Class for Http connection operations
 *
 * @author Haneen Mobaideen
 * 
 */
public class HTTPConnect {

	private static final String EXPEDIA_HOTELS_API_URL_SCHEMA = "https";
	private static final String EXPEDIA_HOTELS_API_URL_AUTHORITY = "offersvc.expedia.com";
	private static final String EXPEDIA_HOTELS_API_URL_PATH = "/offers/v2/getOffers";
	private static final String EXPEDIA_HOTELS_API_ERROR_MSG = "Expedia API is OUT of service, OR not available any more";

	private HTTPConnect() {
	}

	/**
	 * Method to download data from URL
	 * 
	 * @param queryString
	 * @return data downloaded from url
	 * @throws Exception
	 * 
	 */
	public static String download(String queryString) throws Exception {

		URI uri = new URI(EXPEDIA_HOTELS_API_URL_SCHEMA, EXPEDIA_HOTELS_API_URL_AUTHORITY, EXPEDIA_HOTELS_API_URL_PATH,
				queryString, null);

		URL url = new URL(uri.toASCIIString());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int responseCode = con.getResponseCode();

		if (responseCode >= 200 && responseCode < 300) {

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			return response.toString();

		}

		throw new Exception(EXPEDIA_HOTELS_API_ERROR_MSG);
	}

}
