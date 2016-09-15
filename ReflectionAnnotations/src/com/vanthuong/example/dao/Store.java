package com.vanthuong.example.dao;

/*
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

import com.vanthuong.example.annotations.Column;
import com.vanthuong.example.annotations.Permission;
import com.vanthuong.example.model.Customer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vanthuong.example.enums.UserRole.ADMINISTRATION;
import static com.vanthuong.example.enums.UserRole.MANAGER;

public class Store {
  private final Map<Long, Map<String, Object>> customerPropsByIds = new HashMap<>();

  public Store() {
    Map<String, Object> valuesByProperties = new HashMap<>();

    System.out.println("--- Init mock database ---");
    valuesByProperties.put("id", 1L);
    valuesByProperties.put("name", "Nguyen Van A");
    valuesByProperties.put("title", "Manager");
    valuesByProperties.put("address", "Somme where");
    valuesByProperties.put("phoneNumber", "123456789");

    customerPropsByIds.put(1L, valuesByProperties);
  }

  public List<Customer> getCustomers() {
    List<Customer> customers = new ArrayList<>();

    customerPropsByIds.values()
        .forEach(customerPropsByKeys -> {
          Customer customer = new Customer();
          customer.setId((Long) customerPropsByKeys.get("id"));
          customer.setContactName((String) customerPropsByKeys.get("name"));
          customer.setContactTitle((String) customerPropsByKeys.get("title"));
          customer.setAddress((String) customerPropsByKeys.get("address"));
          customer.setPhoneNumber((String) customerPropsByKeys.get("phoneNumber"));

          customers.add(customer);
        });

    return customers;
  }

  @Permission(value = {ADMINISTRATION, MANAGER})
  public void add(Customer customer) {
    if (customer != null) {
      customerPropsByIds.put(customer.getId(), convert(customer));
    }
  }

  public void select(String columnName) {
    // TODO: add your code here to implement this action
  }

  @Permission(value = {ADMINISTRATION, MANAGER})
  public void delete() {
    // TODO: add your code here to implement this action
  }

  @Permission(value = {ADMINISTRATION, MANAGER})
  public void update() {
    // TODO: add your code here to implement this action
  }

  private Map<String, Object> convert(Customer customer) {
    Map<String, Object> valuesByProperties = new HashMap<>();
    Class<?> customerClass = customer.getClass();
    Field[] fields = customerClass.getDeclaredFields();

    for (Field field : fields) {
      getFieldValueByColumn(customer, field, valuesByProperties);
    }

    return valuesByProperties;
  }

  private void getFieldValueByColumn(Customer customer,
                                     Field field,
                                     Map<String, Object> valuesByProperties) {
    field.setAccessible(true);
    try {
      Annotation[] annotations = field.getDeclaredAnnotations();
      for (Annotation annotation : annotations) {
        if (annotation instanceof Column) {
          String propertyName = ((Column) annotation).name();
          Object value = field.get(customer);
          valuesByProperties.put(propertyName, value);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
