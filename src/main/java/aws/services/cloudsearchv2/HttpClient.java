package aws.services.cloudsearchv2;

import java.io.IOException;

import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class HttpClient {
	public static final String ACCEPT_CHARSET = "utf-8";
	public static final MediaType MEDIATYPE_JSON = MediaType.parse("application/json; charset=" + ACCEPT_CHARSET);
	
	public static OkHttpClient client = new OkHttpClient().setConnectionPool(new ConnectionPool(10, 1000));
	
	public static Response sendDocument(String body, String endpoint) throws IOException{

		Request request = new Request.Builder()
			.header("Accept", MEDIATYPE_JSON.toString())
			.header("Content-Type", MEDIATYPE_JSON.toString())
			.url("https://" + endpoint + "/2013-01-01/documents/batch")
			.post(RequestBody.create(MEDIATYPE_JSON, body))
			.build();

		return client.newCall(request).execute();
	}
	
	public static Response sendSearch(String query, String endpoint) throws IOException{

		Request request = new Request.Builder()
			.header("Accept", MEDIATYPE_JSON.toString())
			.header("Content-Type", MEDIATYPE_JSON.toString())
			.url("https://" + endpoint + "/2013-01-01/search?" + query)
			.get()
			.build();

		return client.newCall(request).execute();
	}
	
}
