package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_std_crs", 
		joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
		inverseJoinColumns = {@JoinColumn(name = "COURSE_ID") })
	private List<Course> courses = new ArrayList<>();
	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;
	@OneToOne
	private Address address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String lastName, String gender, Date birthDate) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	public Student(String name, String lastName, String gender, Date birthDate,
			Department department, Address address) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.department = department;
		this.address = address;
	}

	public Student(String name, String lastName, String gender, Date birthDate, List<Course> courses,
			Department department, Address address) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.courses = courses;
		this.department = department;
		this.address = address;
	}

	public Student(String name, String lastName, String gender, Date birthDate, List<Course> courses) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.courses = courses;
	}

	public int getStudentId() {
		return studentId;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", birthDate=" + birthDate
				+ "]";
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
