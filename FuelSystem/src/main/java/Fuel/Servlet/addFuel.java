package Fuel.Servlet;//From the form data is pass to Servlet and it will pass the data to the backend

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fuel.Class.Fuel;
import Fuel.Service.FuelService;

/**
 * Servlet implementation class addFuel
 */
@WebServlet("/addFuel")
public class addFuel extends HttpServlet {//inheritance
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFuel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Fuel fuel =  new Fuel(); //data is set to to fuel object

		fuel.setStock_volume(Integer.parseInt(request.getParameter("stock_volume")));
		fuel.setIntial_volume(Integer.parseInt(request.getParameter("intial_volume")));
		fuel.setDate_consumed(request.getParameter("date_consumed"));
		fuel.setDate_recieved(request.getParameter("date_recieved"));
		
		FuelService s = new FuelService();//from services fuelservice method is called
		int res=s.addFuel(fuel);
		
		if(res==0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addFuel.jsp");//according to the value it is directed to the table
			request.setAttribute("results", 0);
			dispatcher.forward(request, response);
		}else if(res==1) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addFuel.jsp");
			request.setAttribute("results", 1);
			dispatcher.forward(request, response);
		}
	}

}
