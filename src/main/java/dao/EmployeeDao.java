package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import bean.Employee;

public class EmployeeDao {
	
	private static final String Employee = null;
	private Configuration config;
	private ServiceRegistryBuilder builder;
	private ServiceRegistry registry;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	
	public EmployeeDao(){
		config=new Configuration().configure();
		builder=new ServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		registry=builder.buildServiceRegistry();
		factory=config.buildSessionFactory(registry);
		session=factory.openSession();
		transaction=session.beginTransaction();
	}
	
	public void update(Employee employee){
		session.update(employee);
		closed();
	}
	
	public void save(Employee employee){
		session.save(employee);
		closed();
	}
	
	public void delete(Employee employee){
		session.delete(employee);
		closed();
	}
	
	public Employee getEmpById(int id){
		
		Employee employee=(Employee)session.get(Employee.class, id);
		closed();
		return employee;
	}
	
	public List<Employee> getAll(){
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		closed();
		return list;
	}
	
	public void closed(){
		transaction.commit();
		session.close();
		factory.close();
	}

}
