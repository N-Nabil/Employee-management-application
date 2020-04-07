package employees.management.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import employees.management.model.Employee;
public class EmployeeDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3308/mysql?useSSL=false&useUnicode=true" + 
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
			"serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees" + "  (nom, prenom, cin ,type_contrat,sexe,poste,"
			+ "email,num_tel,date_naissance , date_entree) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_EMPLOYEE_BY_ID = "select id,nom, prenom, cin ,type_contrat,sexe,poste,email,num_tel,"
			+ "date_naissance , date_entree from employees where id =?";
	private static final String SELECT_ALL_EMPLOYEES = "select * from employees;";
	private static final String DELETE_EMPLOYEE_SQL = "delete from employees where id = ?;";
	private static final String UPDATE_EMPLOYEE_SQL = "update employees nom =?, prenom=?, cin=? ,type_contrat=?,sexe=?,poste=?,"
			+ "email=?,num_tel=?,date_naissance=? , date_entree=? where id = ?;";


	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void insertEmployee(Employee emp) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			preparedStatement.setString(1, emp.getNom());
			preparedStatement.setString(2, emp.getPrenom());
			preparedStatement.setString(3, emp.getCin());
			preparedStatement.setString(4, emp.getType_contrat());
			preparedStatement.setString(5, emp.getSexe());
			preparedStatement.setString(6, emp.getPoste());
			preparedStatement.setString(7, emp.getEmail());
			preparedStatement.setString(8, emp.getNum_tel());
			preparedStatement.setDate(9, Date.valueOf(emp.getDate_naissance()));
			preparedStatement.setDate(10, Date.valueOf(emp.getDate_entree()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();} catch (SQLException e) {printSQLException(e);}}
	
	//update user
	public boolean updateEmployee(Employee emp) throws SQLException {
		boolean empUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			statement.setString(1, emp.getNom());
			statement.setString(2, emp.getPrenom());
			statement.setString(3, emp.getCin());
			statement.setString(4, emp.getType_contrat());
			statement.setString(5, emp.getSexe());
			statement.setString(6, emp.getPoste());
			statement.setString(7, emp.getEmail());
			statement.setString(8, emp.getNum_tel());
			statement.setDate(9, Date.valueOf(emp.getDate_naissance()));
			statement.setDate(10, Date.valueOf(emp.getDate_entree()));
			statement.setInt(11, emp.getId());
			empUpdated = statement.executeUpdate() > 0;
		}
		return empUpdated;
	}
	

	public Employee selectEmployee(int id) {
		Employee emp = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String cin = rs.getString("cin");
				String type_contrat = rs.getString("type_contrat");
				String sexe = rs.getString("sexe");
				String poste = rs.getString("poste");
				String email = rs.getString("email");
				String num_tel = rs.getString("num_tel");
				LocalDate date_naissance = rs.getDate("date_naissance").toLocalDate();
				LocalDate date_entree = rs.getDate("date_entree").toLocalDate();
				
				emp = new Employee(id,nom, prenom, cin ,type_contrat,sexe,poste,email,num_tel,date_naissance , date_entree);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return emp;
	}

	

	public List<Employee> selectAllEmployees() {

		List<Employee> employees = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String cin = rs.getString("cin");
				String type_contrat = rs.getString("type_contrat");
				String sexe = rs.getString("sexe");
				String poste = rs.getString("poste");
				String email = rs.getString("email");
				String num_tel = rs.getString("num_tel");
				LocalDate date_naissance = rs.getDate("date_naissance").toLocalDate();
				LocalDate date_entree = rs.getDate("date_entree").toLocalDate();
				employees.add(new Employee(id,nom, prenom, cin ,type_contrat,sexe,poste,email,num_tel,date_naissance , date_entree));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}
//delete user by id
	public boolean deleteEmployee(int id) throws SQLException {
		boolean empDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
			statement.setInt(1, id);
			empDeleted = statement.executeUpdate() > 0;
		}
		return empDeleted;
	}
	// error in console
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
