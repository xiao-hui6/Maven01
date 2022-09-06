package com.zte.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmbmsUser {
  private String id;
  private String usercode;
  private String username;
  private String userpassword;
  private String gender;
  private Date birthday;
  private String phone;
  private String address;
  private String userrole;
  private String createdby;
  private Date creationdate;
  private String modifyby;
  private Date modifydate;

  public SmbmsUser(String id, String usercode, String username, String userpassword, String gender) {
    this.id = id;
    this.usercode = usercode;
    this.username = username;
    this.userpassword = userpassword;
    this.gender = gender;
  }

}
