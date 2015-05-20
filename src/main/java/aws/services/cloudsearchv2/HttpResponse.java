package aws.services.cloudsearchv2;

public class HttpResponse {
	private int code;
	private String body;

	public HttpResponse(int code, String body) {
		super();
		this.code = code;
		this.body = body;
	}
	public int getCode() {
		return code;
	}
	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HttpResponse [code=").append(code).append(", body=").append(body).append("]");
		return builder.toString();
	}

}
