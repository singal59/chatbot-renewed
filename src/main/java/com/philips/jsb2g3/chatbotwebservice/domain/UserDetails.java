/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.jsb2g3.chatbotwebservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "Name")
  String name;

  @Column(name = "Contact_No")
  String contactNo;

  @Column(name = "Email")
  String email;



  public UserDetails() {

  }

  public UserDetails(String name, String contactNo, String email) {
    super();
    this.name = name;
    this.contactNo = contactNo;
    this.email = email;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContactNo() {
    return contactNo;
  }

  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (isUser(obj)) {
      final UserDetails other = (UserDetails) obj;
      if (isNameSame(other) && isEmailSame(other) && isContactSame(other)) {
        return true;
      }
    }
    return false;
  }
  private boolean isContactSame(UserDetails other) {
    if (contactNo == null) {
      if (other.contactNo != null) {
        return false;
      }
    } else if (!contactNo.equals(other.contactNo)) {
      return false;
    }
    return true;
  }

  private boolean isNameSame(UserDetails other) {
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  private boolean isEmailSame(UserDetails other) {
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    return true;
  }

  private boolean isUser(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    return (getClass() == obj.getClass());
  }
}
