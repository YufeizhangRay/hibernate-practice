package cn.zyf.hibernate.subclass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HibernateTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@BeforeEach
	public void init() {
		ServiceRegistry serviceRegistry  = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@AfterEach
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 缺点：
	 * 1.使用了辨别者列
	 * 2.子类独有的字段不能添加非 null 约束
	 * 3.若继承层次较深则数据表的字段也会较多
	 */
	
	/**
	 * 查询:
	 * 1.查询父类记录，只需要查询一张数据表
	 * 2.对于子类记录，也只需要查一张数据表
	 */
	@Test
	public void testQuery() {
		List<Person> persons = session.createQuery("From Person").list();
		System.out.println(persons.size());
		
		List<Student> students = session.createQuery("From Student").list();
		System.out.println(students.size());
	}
	
	/**
	 * 插入操作：
	 * 1.对于子类对象只需把记录插入到一张数据表中
	 * 2.辨别者列由 hibernate 自动维护
	 */
	@Test
	public void testSave() {
		Person person = new Person();
		person.setAge(11);
		person.setName("AA");
		
		session.save(person);
		
		Student student = new Student();
		student.setAge(22);
		student.setName("BB");
		student.setSchool("MIT");
		
		session.save(student);
	}
}
