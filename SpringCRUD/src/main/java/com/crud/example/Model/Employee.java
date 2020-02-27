/**
 *
 */
package com.crud.example.Model;

import java.io.Serializable;

/**
 * @author nitin
 *
 */
public class Employee implements Serializable {

	private Integer id;
    private String name;
    private Integer age;
    private String dept;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, String name, Integer age, String dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}

}
