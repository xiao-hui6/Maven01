package com.zte.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
