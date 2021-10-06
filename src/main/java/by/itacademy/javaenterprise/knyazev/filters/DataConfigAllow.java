package by.itacademy.javaenterprise.knyazev.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.itacademy.javaenterprise.knyazev.config.Config;

public class DataConfigAllow {
	private List<String> contentTypes;
	private List<String> ipAddresses;
	private List<String> macAddresses;
	private static DataConfigAllow dataConfig;

	private DataConfigAllow() {
		contentTypes = new ArrayList<>();
		ipAddresses = new ArrayList<>();
		macAddresses = new ArrayList<>();
		
		Collections.addAll(contentTypes, Config.ALLOW_CONTENT_TYPES);
		Collections.addAll(ipAddresses, Config.ALLOW_IP_ADDRESSES);
		Collections.addAll(macAddresses, Config.ALLOW_MAC_ADDRESSES);
	}

	public static DataConfigAllow getInstance() {
		if (dataConfig == null) {
			dataConfig = new DataConfigAllow();
		}

		return dataConfig;
	}

	public boolean checkContentType(String contentType) {
		return check(contentType, contentTypes);
	}
	
	public boolean checkIpAddress(String ipAddress) {
		return check(ipAddress, ipAddresses);
	}
	
	public boolean checkMackAddresses(String macAddress) {
		return check(macAddress, macAddresses);
	}
	
	private boolean check(String value, List<String> data) {
		if (data.contains(value)) return true;
		return false;
	}
}
