package com.ds.algorithms.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroceryProduct {

	public static class Customer {

		String name;
		String phone;
		String country;
		String city;
		String fruit;
		Double qty;
		Double price;
		Double total;
		Double amount;

		public Customer() {
			super();
		}

		public Customer(String name, String phone, String country, String city, String fruit, String qty,
				String price) {
			this.name = name;
			this.phone = phone;
			this.country = country;
			this.city = city;
			this.fruit = fruit;
			this.qty = new Double(qty);
			this.price = new Double(price);
			this.total = new Double(0);
			this.amount = new Double(0);
		}

		@Override
		public int hashCode() {
			return Objects.hash(amount, city, country, fruit, name, phone, price, qty, total);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			return Objects.equals(amount, other.amount) && Objects.equals(city, other.city)
					&& Objects.equals(country, other.country) && Objects.equals(fruit, other.fruit)
					&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
					&& Objects.equals(price, other.price) && Objects.equals(qty, other.qty)
					&& Objects.equals(total, other.total);
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

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String ciity) {
			this.city = ciity;
		}

		public String getFruit() {
			return fruit;
		}

		public void setFruit(String fruit) {
			this.fruit = fruit;
		}

		public Double getQty() {
			return qty;
		}

		public void setQty(Double qty) {
			this.qty = qty;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double total) {
			this.amount = total;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + ", phone=" + phone + ", country=" + country + ", city=" + city
					+ ", fruit=" + fruit + ", qty=" + qty + ", price=" + price + "]";
		}

	}

	public static void main(String args[]) {

		List<Customer> data = new ArrayList<>();
		Customer cust = new Customer("Giri Kanada", "2349078885", "India", "Bangalore", "Banana", "3", "45.00");
		Customer cust1 = new Customer("Giri Kanada", "2349078885", "India", "Bangalore", "Banana", "3", "45.00");
		Customer cust2 = new Customer("Giri Kanada", "2349078885", "India", "Bangalore", "Coconut", "3", "10.00");
		Customer cust3 = new Customer("Giri Kanada", "2349078885", "India", "Bangalore", "Apple", "2", "240.00");
		Customer cust4 = new Customer("Giri Kanada", "2349078885", "India", "Bangalore", "Orange", "2", "140.00");
		Customer cust5 = new Customer("Kanada", "2349078886", "India", "Bangalore", "Banana", "23", "45.00");
		Customer cust6 = new Customer("Kanada", "2349078886", "India", "Bangalore", "Coconut", "13", "10.00");
		Customer cust7 = new Customer("Kanada", "2349078886", "India", "Bangalore", "Apple", "2", "240.00");
		Customer cust8 = new Customer("Kanada", "2349078886", "India", "Bangalore", "Kiwi", "2", "140.00");
		data.add(cust);
		data.add(cust1);
		data.add(cust2);
		data.add(cust3);
		data.add(cust4);
		data.add(cust5);
		data.add(cust6);
		data.add(cust7);
		data.add(cust8);

		List<Customer> distinct = data.stream().distinct().toList();
		System.out.println("Distinct object" + distinct);
		Map<String, List<Customer>> groups = distinct.stream().collect(Collectors.groupingBy(Customer::getPhone));
		System.out.println("grouped objects  " + groups);
		System.out.println("key values from map  " + groups.keySet());
		findTotal(groups, distinct);
	}

	private static void findTotal(Map<String, List<Customer>> groups, List<Customer> distinct) {
		groups.keySet().stream().forEach(g -> {
			distinct.get(0).setAmount(new Double(0));
			distinct.stream().forEach(c -> {
				if (c.getPhone().equals(g)) {
					distinct.get(0).setAmount(Double.sum(distinct.get(0).getAmount(), (c.getQty() * c.getPrice())));
				}
			});
			System.out.println("Total amount  " + g + "   " + distinct.get(0).getAmount());
		});
	}
}
