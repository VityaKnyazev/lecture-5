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

@WebFilter(filterName = "contentTypeFilter", urlPatterns = {"/represent"})
public class ContentTypeFilter extends HttpFilter {

	private static final long serialVersionUID = -8327627441830625622L;

	private DataConfigAllow dataConfigAllow;
	private Logger logger;

	public ContentTypeFilter() {
		dataConfigAllow = DataConfigAllow.getInstance();
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String contentType = req.getContentType();
		logger.log(Level.INFO, "Executing " + this.getFilterName() + " filter");

		if (contentType == null || !dataConfigAllow.checkContentType(contentType)) {
			res.setContentType(Config.ALLOW_CONTENT_TYPES[0]);
			res.sendError(HttpServletResponse.SC_BAD_REQUEST, "BAD content type, text/html allows only.");

			logger.log(Level.WARNING, "Sending error response on bad contentType: " + contentType + ". Waiting: " + Config.ALLOW_CONTENT_TYPES[0]);
			return;
		}

		logger.log(Level.INFO, this.getFilterName() + " filter successfully finished work");

		chain.doFilter(req, res);

	}

}
