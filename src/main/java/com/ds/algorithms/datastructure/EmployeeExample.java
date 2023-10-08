package com.ds.algorithms.datastructure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeExample {
	
	public static class Employee{
		
		BigDecimal empId;
		String name;
		String phone;
		String dept;
		String country;
		String city;
		Double salary;
		
		public Employee(String empId, String name, String phone, String country, String dept,  String city,
				String salary) {
			super();
			this.empId = new BigDecimal(empId);
			this.name = name;
			this.phone = phone;
			this.dept = dept;
			this.country = country;
			this.city = city;
			this.salary = new Double(salary);
		}
		
		public BigDecimal getEmpId() {
			return empId;
		}
		public void setEmpId(BigDecimal empId) {
			this.empId = empId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		@Override
		public int hashCode() {
			return Objects.hash(city, country, dept, empId, name, phone, salary);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return Objects.equals(city, other.city) && Objects.equals(country, other.country)
					&& Objects.equals(dept, other.dept) && Objects.equals(empId, other.empId)
					&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
					&& Objects.equals(salary, other.salary);
		}
		
	}

	public static void main(String args[]) {
		List<Employee> data = new ArrayList<>();
		Employee cust = new Employee("101","Giri Kanada","2349078885","India","IT","Bangalore","60000");
		Employee cust1 = new Employee("101","Giri Kanada","2349078885","India","IT","Bangalore","60000");
		Employee cust2 = new Employee("101","Giri Kanada","2349078885","India","IT","Bangalore","60000");
		Employee cust3 = new Employee("102","Giri Kanada","2349078882","India","IT","Bangalore","60000");
		Employee cust4 = new Employee("103","Giri Kanada","2349078888","India","IT","Bangalore","160000");
		Employee cust5 = new Employee("104","Giri Kanada","2349078888","India","IT","Bangalore","200000");
		Employee cust6 = new Employee("105","Giri Kanada","2349078888","India","IT","Bangalore","456780");
		Employee cust7 = new Employee("105","Giri Kanada","2349078888","India","IT","Bangalore","45678");
		
		data.add(cust);
		data.add(cust1);
		data.add(cust2);
		data.add(cust3);
		data.add(cust4);
		data.add(cust5);
		data.add(cust6);
		data.add(cust7);
		
		List<Employee> distinct = data.stream().distinct().toList();
		List<Employee> groups = distinct.stream().filter(e -> ((e.getSalary().compareTo(new Double("50000"))>0)&&
				(e.getDept().equalsIgnoreCase("IT")))).toList();
		
		groups.stream().forEach(p -> {;
		
		System.out.println("Employee name with salary and dept  "+ p.getName() +" "+p.getEmpId()+" "+p.getDept());
		});
		
	}
}
