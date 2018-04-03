package test;

import java.util.List;

import org.junit.Test;

import bean.Employee;
import dao.EmployeeDao;

public class testCRUD{
	

	
	@Test
	public void testGetAll(){
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.getAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	
	
	
	
}
