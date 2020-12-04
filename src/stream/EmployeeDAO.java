package stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;

public class EmployeeDAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
//	1> salary 10000 이상인 사람 출력 - 사원번호 이름 메일 급여
	public List getEmpList() {
		conn = DAO.getConnection();
		sql = "SELECT employee_id, last_name,email,salary FROM emp1 WHERE salary >= ?";
		List list = new ArrayList();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmpNo(rs.getInt("Employee_id"));
				vo.setLastName(rs.getNString("Last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("Salary"));
				list.add(vo);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			
		}return list;
	
	
	}
	
//	2> 선적부서, 급여합계(평균)
	public List getEmpList1() {
		conn = DAO.getConnection();
		sql = "SELECT employee_id, last_name,email,salary FROM emp1 WHERE department_id=?";
		List list = new ArrayList();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmpNo(rs.getInt("Employee_id"));
				vo.setLastName(rs.getNString("Last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("Salary"));
				list.add(vo);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			
		}return list;
	
	
	}
//	3>급여(5000~10000) 사원번호, 이름, 메일, 급여 
	public List getEmpList2() {
		conn = DAO.getConnection();
		sql = "SELECT employee_id, last_name,email,salary FROM emp1 WHERE salary between ? and ?; ";
		List list = new ArrayList();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmpNo(rs.getInt("Employee_id"));
				vo.setLastName(rs.getNString("Last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("Salary"));
				list.add(vo);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			
		}return list;
		
	}

	public static Connection getConnection() // connection 타입의 값이 반환
	{
		Connection conn = null;
		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}

}
