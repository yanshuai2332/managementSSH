package com.mag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity  
@Table(name="base_user")  
public class User {  
      
    @Id  
    @GeneratedValue(generator = "system-uuid")  //使用uuid生成主键的方式  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")   
    @Column(length=255)  
    private String id;  
      
    @Column(length=255)  
    private String userName;  
    @Column(length=255)  
    private String password;
    @Column(length=255)  
    private String nickName;
    @Column(length=10)  
    private int sex;
    @Column(length=255)  
    private String phone;  
    @Column(length=255)  
    private String portrait;
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
   
      
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}  
  
}  