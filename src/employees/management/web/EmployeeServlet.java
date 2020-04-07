package employees.management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import employees.management.dao.*;
import employees.management.model.Employee;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
       this.empDAO= new EmployeeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request . getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = empDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existEmployee = empDAO.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("emp", existEmployee);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String type_contrat = request.getParameter("type_contrat");
		String sexe = request.getParameter("sexe");
		String poste = request.getParameter("poste");
		String email = request.getParameter("email");
		String num_tel = request.getParameter("num_tel");
		LocalDate date_naissance = LocalDate.parse(request.getParameter("date_naissance"));
		LocalDate date_entree = LocalDate.parse(request.getParameter("date_entree"));
		Employee newEmployee = new Employee(nom, prenom, cin ,type_contrat,sexe,poste,email,num_tel,date_naissance , date_entree) ;
		empDAO.insertEmployee(newEmployee);
		response.sendRedirect("list");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String type_contrat = request.getParameter("type_contrat");
		String sexe = request.getParameter("sexe");
		String poste = request.getParameter("poste");
		String email = request.getParameter("email");
		String num_tel = request.getParameter("num_tel");
		LocalDate date_naissance = LocalDate.parse(request.getParameter("date_naissance"));
		LocalDate date_entree = LocalDate.parse(request.getParameter("date_entree"));
		Employee empUpdate = new Employee(id,nom, prenom, cin ,type_contrat,sexe,poste,email,num_tel,date_naissance , date_entree);
		empDAO.updateEmployee(empUpdate);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empDAO.deleteEmployee(id);
		response.sendRedirect("list");

	}

	

}
