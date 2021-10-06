package by.itacademy.javaenterprise.knyazev.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.javaenterprise.knyazev.config.Config;

@WebFilter(filterName = "ipAddressFilter", urlPatterns = { "/represent" })
public class IpAddressFilter extends HttpFilter {

	private static final long serialVersionUID = 2415802850102556090L;

	private DataConfigAllow dataConfigAllow;
	private Logger logger;
	
	public IpAddressFilter() {
		dataConfigAllow = DataConfigAllow.getInstance();
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
	String ipAddress = req.getRemoteAddr();
	logger.log(Level.INFO, "Executing ContentTypeFilter");

	if (ipAddress == null || !dataConfigAllow.checkIpAddress(ipAddress)) {
		res.setContentType(Config.ALLOW_IP_ADDRESSES[0]);
		res.sendError(HttpServletResponse.SC_BAD_REQUEST, "BAD IP addres.");

		logger.log(Level.WARNING, "Sending error response from bad ip address: " + ipAddress + ". Waiting: " + Config.ALLOW_IP_ADDRESSES[0]);
		return;
	}

	logger.log(Level.INFO, this.getFilterName() + " filter successfully finished work");

	chain.doFilter(req, res);
	}
}


