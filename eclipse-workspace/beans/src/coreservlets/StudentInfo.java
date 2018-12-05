package coreservlets;

/** 
1. Create a bean class "studentInfo" that collects following information from StudentInfo.html.
First name, Middle Initial, Last Name, SSN
2. Create a showStudentInfo.jsp page that shows what user typed in using studentInfo bean class.
No java codes are allowed in this page.
 */

public class StudentInfo {
  private String firstName = "No first name specified";
  private String middleInitial = "No middle initial specified";
  private String lastName = "No last name specified";
  private String ssn = "No SSN specified";

  public String getFirstName() {
	  return(firstName);
  }

  public void setFirstName(String firstName) {
	  this.firstName = firstName;
  }
  
  public String getMiddleInitial() {
	  return(middleInitial);
  }

  public void setMiddleInitial(String middleInitial) {
	  this.middleInitial = middleInitial;
  }

  public String getLastName() {
	  return(lastName);
  }

  public void setLastName(String lastName) {
	  this.lastName = lastName;
  }
  
  public String getSsn() {
	  return(ssn);
  }

  public void setSsn(String ssn) {
	  this.ssn = ssn;
  }
	  
	  
}
