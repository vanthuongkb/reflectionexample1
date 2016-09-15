package com.vanthuong.example.model;

import com.vanthuong.example.annotations.Column;
import com.vanthuong.example.annotations.Table;

/*
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

@Table(name = "customers")
public class Customer {

  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String contactName;

  @Column(name = "title")
  private String contactTitle;

  @Column(name = "address")
  private String address;

  @Column(name = "phoneNumber")
  private String phoneNumber;

  public Customer() {
  }

  public Customer(Long id, String contactName, String contactTitle, String address, String phoneNumber) {
    this.id = id;
    this.contactName = contactName;
    this.contactTitle = contactTitle;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getContactTitle() {
    return contactTitle;
  }

  public void setContactTitle(String contactTitle) {
    this.contactTitle = contactTitle;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", contactName='" + contactName + "'" +
        ", contactTitle='" + contactTitle + "'" +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + "'" +
        "}";
  }
}
