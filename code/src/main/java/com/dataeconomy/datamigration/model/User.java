package com.dataeconomy.datamigration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Book")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long SR_NO;
   private String USER_ID;
   private String USER_ROLE;
   private String EMAIL_ID;
   private String PASSWORD;
public Long getSR_NO() {
	return SR_NO;
}
public void setSR_NO(Long sR_NO) {
	SR_NO = sR_NO;
}
public String getUSER_ID() {
	return USER_ID;
}
public void setUSER_ID(String uSER_ID) {
	USER_ID = uSER_ID;
}
public String getUSER_ROLE() {
	return USER_ROLE;
}
public void setUSER_ROLE(String uSER_ROLE) {
	USER_ROLE = uSER_ROLE;
}
public String getEMAIL_ID() {
	return EMAIL_ID;
}
public void setEMAIL_ID(String eMAIL_ID) {
	EMAIL_ID = eMAIL_ID;
}
public String getPASSWORD() {
	return PASSWORD;
}
public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}

   

}
