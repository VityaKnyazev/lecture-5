package by.itacademy.javaenterprise.knyazev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.javaenterprise.knyazev.config.Config;
import by.itacademy.javaenterprise.knyazev.db.CarConnection;
import by.itacademy.javaenterprise.knyazev.entities.Car;
import by.itacademy.javaenterprise.knyazev.services.CarService;
import by.itacademy.javaenterprise.knyazev.validators.IntegerRequestValidator;
import by.itacademy.javaenterprise.knyazev.validators.LongRequestValidator;
import by.itacademy.javaenterprise.knyazev.validators.StringRequestValidator;

@WebServlet(name = "representationServlet", urlPatterns = {"/represent"})
public class CarsServlet extends HttpServlet {

	private static final long serialVersionUID = -4601369534593311766L;

	private static final String MAIN_TMPL = "/WEB-INF/tmpl/representation.jsp";
	private CarService carService;
	
	public  CarsServlet() {
		carService = new CarService();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		IntegerRequestValidator validator = new IntegerRequestValidator(CarConnection.DEFAULT_CAR_ID,
				carService.getAllData().size() - 1);
		
		if (validator.isNull(id)) {
			req.setAttribute("cars", carService.getAllData());
		} else if (validator.validate(id)) {			
			req.setAttribute("car", carService.getSingleData(Integer.parseInt(id)));
		} else {
			resp.setStatus(400);
			resp.setContentType("text/html; charset=utf-8");
			req.setAttribute("id", id);
		}

		req.getRequestDispatcher(MAIN_TMPL).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firm = req.getParameter("firm");
		String model = req.getParameter("model");
		String serialNumber = req.getParameter("serialNumber");
		
		StringRequestValidator stringValidator = new StringRequestValidator(Config.STRING_REQUEST_MIN_SIZE, Config.STRING_REQUEST_MAX_SIZE);
		LongRequestValidator longValidator = new LongRequestValidator(Config.LONG_REQUEST_MIN_SIZE, Config.LONG_REQUEST_MAX_SIZE);
		
		if (stringValidator.validate(firm) && stringValidator.validate(model) && longValidator.validate(serialNumber)) {
			Car car = carService.createCar(firm, model, Long.parseLong(serialNumber));
			carService.addData(car);
			req.setAttribute("post", Config.SUCCESSFULL_POST_REQUEST);
		} else {
			resp.setStatus(400);
			resp.setContentType("text/html; charset=utf-8");
			req.setAttribute("post", Config.BAD_POST_REQUEST);
		}
		
		req.getRequestDispatcher(MAIN_TMPL).forward(req, resp);		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		resp.setContentType("text/html; charset=utf-8");		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		resp.setContentType("text/html; charset=utf-8");
	}
}