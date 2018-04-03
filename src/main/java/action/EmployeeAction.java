package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import bean.Employee;
import dao.EmployeeDao;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable{
	
	private Employee employee;
	
	public EmployeeAction(){
		System.out.println("EmployeeAction");
	}
	
	private EmployeeDao dao;
	
	//获取所有员工信息
	public String list(){
		dao=new EmployeeDao();
		List<Employee> list = dao.getAll();
		request.put("list", list);
		return "list";
	}
	
	public String del(){
		dao=new EmployeeDao();
		dao.delete(employee);
		return "success";
	}
	
	//修改信息之前的回显操作
	public String input(){
		return "input";
	}
	
	public Employee getModel() {
		return employee;
	}
	
	public void prepareInput() throws Exception {
		dao=new EmployeeDao();
		employee=dao.getEmpById(employee.getId());
	}
	
	public String add(){
		System.out.println(employee);
		dao=new EmployeeDao();
		dao.save(employee);
		return "success";
	}
	
	
	public String update(){
		System.out.println(employee);
		dao=new EmployeeDao();
		dao.update(employee);
		return "success";
	}
	
	
	
	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void prepare() throws Exception {
		
	}

}
