package com.vanthuong.example;

/*
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

import com.vanthuong.example.dao.Store;
import com.vanthuong.example.model.Customer;

import java.util.List;

public class Application {
  public static void main(String[] args) {
    Store store = new Store();

    List<Customer> customers = store.getCustomers();
    System.out.println("--- LIST OF CUSTOMERS ---");
    customers.forEach(System.out::println);

    System.out.println("--- ADD NEW CUSTOMER ---");
    Customer customer = new Customer();
    customer.setId(2L);
    customer.setContactName("Thuong Van Nguyen");
    customer.setContactTitle("Software Engineer");
    customer.setPhoneNumber("123123123123");
    customer.setAddress("HCM");
    store.add(customer);

    List<Customer> customerList = store.getCustomers();
    System.out.println("--- LIST OF CUSTOMERS ---");
    customerList.forEach(System.out::println);
  }
}
