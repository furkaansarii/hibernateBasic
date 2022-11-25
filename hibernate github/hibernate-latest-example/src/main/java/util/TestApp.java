package util;

import java.util.Date;


import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Address;
import entity.Course;
import entity.Department;
import entity.Student;

public class TestApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		
		Student student = TestApp.showStudentByName(session, "Ahmet");
		
		System.out.println("Öğrenci Adı:"+student);
		session.getTransaction().commit();
	}
	
	private static Student showStudentByName(Session session , String name) {
		Query<Student> query = session.createQuery("FROM Student s WHERE s.name=:name", Student.class)
				.setParameter("name", name);
		Student student = query.uniqueResult();
		return student;
	}
	
	private void addStudentWtihAllParameters() {

		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		Address address1 = new Address("10.sk","İzmir","Balçova","35100"); //üni adres
		Address address2 = new Address("7.sk","İzmir","Balçova",null);
		Address address3 = new Address("9.sk","İzmir",null,null);
		Address address4 = new Address("15.sk","İzmir","Balçova",null);
		Address address5 = new Address(null,"İzmir","Balçova",null);
		
		session.save(address1);
		session.save(address2);
		session.save(address3);
		session.save(address4);
		session.save(address5);
		
		Department dept1 = new Department("Bilgisayar Müh.");
		Department dept2 = new Department("Endüstri Müh.");
		Department dept3 = new Department("Mimarlık");
		Department dept4 = new Department("İşletme");
		
		session.save(dept1);
		session.save(dept3);
		session.save(dept2);
		session.save(dept4);
		
		Course course1 = new Course("Introduction to Comp. Prog.");
		Course course2 = new Course("Calculus I");
		Course course3 = new Course("Besic Design");
		Course course4 = new Course("Perspective");
		Course course5 = new Course("Accounting");
		Course course6 = new Course("Statistics");
		Course course7 = new Course("French I");
		Course course8 = new Course("Engineering Economy");
		
		Student std1 = new Student("Ahmet","Çelik","Erkek",new Date("06/07/1990"),dept1,address1);
		Student std2 = new Student("Ömer","Doğan","Erkek",new Date("09/09/1987"),dept2,address2);
		Student std3 = new Student("Demet","Öztürk","Kadın",new Date("07/05/1990"),dept3,address3);
		Student std4 = new Student("Emel","Çelik","Kadın",new Date("10/10/1995"),dept1,address4);
		Student std5 = new Student("Begüm","Ünlü","Kadın", new Date("05/03/1994"), dept4, address5);
		
		std1.getCourses().add(course8);
		std1.getCourses().add(course1);
		std1.getCourses().add(course3);
		
		std2.getCourses().add(course8);
		std1.getCourses().add(course5);
		
		std3.getCourses().add(course1);
		std3.getCourses().add(course2);
		std3.getCourses().add(course4);
		std3.getCourses().add(course7);
		
		std4.getCourses().add(course6);
		std4.getCourses().add(course5);
		
		std5.getCourses().add(course6);
		std5.getCourses().add(course7);
		
		session.save(std1);
		session.save(std2);
		session.save(std3);
		session.save(std4);
		session.save(std5);
		session.getTransaction().commit();
	}

}
