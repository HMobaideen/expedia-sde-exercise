package com.hmobaideen.expedia.hotels.business;

import javax.ws.rs.core.MultivaluedMap;

import com.hmobaideen.expedia.hotels.util.HTTPConnect;

/**
 * <h1>HotelBusiness</h1>
 * 
 * Class to handle hotel operations
 * 
 * @author Haneen Mobaideen
 *
 */
public class HotelBusiness {

	private static final String EXPEDIA_HOTELS_API_URL_QUERY_STRING = "scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
	private static final String QUERY_PARAM_OPERATOR_AND = "&";
	private static final String QUERY_PARAM_OPERATOR_EQUAL = "=";

	/**
	 * Method to get filtered hotels based on filter parameters
	 * 
	 * @param filterParams
	 * @return JSON as String
	 * @throws Exception
	 * 
	 */
	public String getHotels(MultivaluedMap<String, String> filterParams) throws Exception {
		return HTTPConnect.download(getHotelsFilterAsQueryString(filterParams));
	}

	/**
	 * Method to convert filter parameters (MultivaluedMap <key,values>) to URL
	 * query string parameter
	 * 
	 * @param filterParams
	 * @return URL query string
	 * 
	 */
	private String getHotelsFilterAsQueryString(MultivaluedMap<String, String> filterParams) {

		StringBuilder hotelsFilterAsQueryString = new StringBuilder(EXPEDIA_HOTELS_API_URL_QUERY_STRING);

		for (String filterParam : filterParams.keySet()) {
			String filterParamValue = filterParams.getFirst(filterParam);
			if (filterParamValue != null && !filterParamValue.isEmpty()) {
				hotelsFilterAsQueryString.append(QUERY_PARAM_OPERATOR_AND + filterParam);
				hotelsFilterAsQueryString.append(QUERY_PARAM_OPERATOR_EQUAL + filterParamValue);
			}
		}

		return hotelsFilterAsQueryString.toString();
	}
}
