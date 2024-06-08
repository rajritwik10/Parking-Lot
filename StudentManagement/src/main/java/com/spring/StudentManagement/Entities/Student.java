package com.spring.StudentManagement.Entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
@Entity

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int Id;
	@Column(name="Student_Name")
	public String name;
	public String contact;
	public String emailId;
	
}
