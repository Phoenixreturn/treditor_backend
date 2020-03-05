package com.devon.treditor.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
	public Student(String studentName, int studentAge) {
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	@Id
	private String id;
	String studentName;
	int studentAge;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return String.format("Student[id=%s, studentName='%s', studentAge=" + studentAge + "]", id, studentName);
	}
}