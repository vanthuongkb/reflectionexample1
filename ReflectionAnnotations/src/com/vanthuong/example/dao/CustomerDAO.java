package com.vanthuong.example.dao;

import com.vanthuong.example.annotations.Permission;
import com.vanthuong.example.enums.Action;
import com.vanthuong.example.enums.UserRole;
import com.vanthuong.example.exceptions.CustomException;
import com.vanthuong.example.model.Customer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.vanthuong.example.enums.Action.ADD;
import static com.vanthuong.example.enums.UserRole.ADMINISTRATION;

/**
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */
public class CustomerDAO {
  private final Store store;

  public CustomerDAO() {
    store = new Store();
  }

  public List<Customer> getAll() {
    return store.getCustomers();
  }

  public void add(Customer customer) throws CustomException {
    // Hard code to execute method with Administration right
    if(hasPermission(ADD, ADMINISTRATION)) {
      store.add(customer);
    } else {
      throw new CustomException("You don't have permission to performce this action");
    }
  }

  private boolean hasPermission(Action action, UserRole userRole) throws CustomException {
    Class<?> storeClass = store.getClass();
    List<UserRole> permissions = new ArrayList<>();

    try {
      Method method = storeClass.getMethod(action.value());
      Annotation[] annotations = method.getDeclaredAnnotations();
      permissions.addAll(getPermissions(annotations));

      return permissions.isEmpty() || permissions.contains(userRole);
    } catch (NoSuchMethodException e) {
      throw new CustomException(
          String.format("Action %s is not existing in %s class", action.value(), storeClass.getName()));
    }
  }

  private List<UserRole> getPermissions(Annotation[] annotations) {
    List<UserRole> roles = new ArrayList<>();
    for (Annotation annotation : annotations) {
      if (annotation instanceof Permission) {
        Permission permission = (Permission) annotation;
        UserRole[] permissionRoles = permission.value();
        if (permissionRoles.length > 0) {
          roles.addAll(Arrays.asList(permissionRoles));
        }
      }
    }
    return roles;
  }
}
