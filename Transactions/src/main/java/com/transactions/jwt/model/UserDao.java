package com.transactions.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDao {
	//GenerationType.IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 1;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    @Column
    private String fName;
    @Column
    private String lName;
    @Column
    private String email;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
    
}
