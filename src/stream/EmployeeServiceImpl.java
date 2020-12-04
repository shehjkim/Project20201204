package stream;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();
	
	@Override
	public List getEmpList() {
		return dao.getEmpList();
		
	}



}
