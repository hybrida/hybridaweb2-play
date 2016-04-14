package exceptions;

public class ServerError extends Exception {
	private int statusCode;

	public ServerError() {
		this(500);
	}

	public ServerError(int responseCode) {
		this.statusCode = responseCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
