package com.iktpreobuka.securityexamplebasic.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
	public class UserEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;
	@Column (name = "last_name")
	private String lastName;
	@JsonIgnore
	private String password;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name = "role")
	private RoleEntity role;

		public UserEntity() {
			super();
		}

		public UserEntity(Integer id, String email, String name, String lastName, String password, RoleEntity role) {
			super();
			this.id = id;
			this.email = email;
			this.name = name;
			this.lastName = lastName;
			this.password = password;
			this.role = role;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public RoleEntity getRole() {
			return role;
		}

		public void setRole(RoleEntity role) {
			this.role = role;
		}
	}
