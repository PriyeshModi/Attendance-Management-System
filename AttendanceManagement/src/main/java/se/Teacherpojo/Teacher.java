package se.Teacherpojo;

import java.util.Date;

public class Teacher {
	public String name;
    public int teacherId;

	public String classAlloted;
    public String gender;
    public String emailId;
    public String Mobno;
   public String password;
public Teacher(String name, int teacherId, String classAlloted, String gender, String emailId, String mobno,
		String password) {
	super();
	this.name = name;
	this.teacherId = teacherId;
	this.classAlloted = classAlloted;
	this.gender = gender;
	this.emailId = emailId;
	Mobno = mobno;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getTeacherId() {
	return teacherId;
}
public void setTeacherId(int teacherId) {
	this.teacherId = teacherId;
}
public String getClassAlloted() {
	return classAlloted;
}
public void setClassAlloted(String classAlloted) {
	this.classAlloted = classAlloted;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getMobno() {
	return Mobno;
}
public void setMobno(String mobno) {
	Mobno = mobno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   

}
    
   