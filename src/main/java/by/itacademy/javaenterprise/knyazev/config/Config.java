package by.itacademy.javaenterprise.knyazev.config;

public final class Config {
	public static final int STRING_REQUEST_MIN_SIZE = 3;
	public static final int STRING_REQUEST_MAX_SIZE = 25;
	
	public static final long LONG_REQUEST_MIN_SIZE = 0L;
	public static final long LONG_REQUEST_MAX_SIZE = Long.MAX_VALUE;
	
	public static final String SUCCESSFULL_POST_REQUEST = "success";
	public static final String BAD_POST_REQUEST = "failed";
	
	public static final String[] ALLOW_CONTENT_TYPES = {"text/html; charset=utf-8"};
	public static final String[] ALLOW_IP_ADDRESSES = {"0:0:0:0:0:0:0:1", "127.0.0.1", "localhost"};
	public static final String[] ALLOW_MAC_ADDRESSES = {"ac:e0:10:6a:0c:72"};
}
