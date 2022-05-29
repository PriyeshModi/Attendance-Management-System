package se.studentpojo;

import java.util.Date;

public class Student {
   public String name;
   public int rollno;
   public String Clas;
   public String parentMob;
   public String address;
   public String gender;
   public int attendence;
   public String password;
   public int total_attendence;
public Student(String name, int rollno, String Clas, String parentMob, String address, String gender, String password,int attendence, int total_attendence) {
	
	this.name = name;
	this.rollno = rollno;
	this.Clas = Clas;
	this.parentMob = parentMob;
	this.address = address;
	this.gender = gender;
	this.attendence = attendence;
	this.password = password;
	this.total_attendence=total_attendence;
}

@Override
public String toString() {
	return "Student [name=" + name + ", rollno=" + rollno + ", Clas=" + Clas + ", parentMob=" + parentMob + ", address="
			+ address + ", gender=" + gender + ", attendence=" + attendence + ", password=" + password + "]";
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getClas() {
	return Clas;
}
public void setClass(String class1) {
	Clas = class1;
}
public String getParentMob() {
	return parentMob;
}
public void setParentMob(String parentMob) {
	this.parentMob = parentMob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAttendence() {
	return attendence;
}
public void setAttendence(int attendence) {
	this.attendence = attendence;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getTotal_attendence() {
	return total_attendence;
}

public void setTotal_attendence(int total_attendence) {
	this.total_attendence = total_attendence;
}

   

}
