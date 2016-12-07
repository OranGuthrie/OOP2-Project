//Adoptions.java
/*This is the Adoptions class for the Orphanage System.*/

/**
 *The Adoptions program is a class that creates an adoption object
 *which is used in the Orphanage System.
 *
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */
public class Adoptions{
	
	private String childName;
	private String guardian1Name;
	private String guardian2Name;
	private String address;
	private String dob1;
	private String dob2;
	private String adoptionDate;
/**
 *This is the No-Argument Constructer.
 *
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */	
	public Adoptions(){
		childName = "No Name Specified";
		guardian1Name = "No Name Specified";
		guardian2Name = "No Name Specified";
		address = "No Address Specified";
		dob1 = "dd/mm/YYYY";
		dob2 = "dd/mm/YYYY";
	}
/**
 *This is the Multiple-Argument Constructor.
 *
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */
	public Adoptions(String childName, String guardian1Name, String guardian2Name, String address, String dob1, String dob2){
		this.childName = childName;
		this.guardian1Name = guardian1Name;
		this.guardian2Name = guardian2Name;
		this.address = address;
		this.dob1 = dob1;
		this.dob2 = dob2;
	}
/**
 *This is the mutator method for childName.
 *It is used to control changes to the variable.
 *<p>
 *The following methods are mutator methods for their respective variables.
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */	
	public void setChildName(String childName){
		this.childName = childName;
	}
	public void setGuardian1Name(String guardian1Name){
		this.guardian1Name = guardian1Name;
	}
	public void setGuardian2Name(String guardian2Name){
		this.guardian2Name = guardian2Name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setDob1(String dob1){
		this.dob1 = dob1;
	}
	public void setDob2(String dob2){
		this.dob2 = dob2;
	}
/**
 *This is the accessor method for childName.
 *It returns the value of the private member variable. 
 *<p>
 *The following methods are accessor methods for their respective variables.
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */	
	public String getChildName(){
		return childName;
	}
	public String getGuardian1Name(){
		return guardian1Name;
	}
	public String getGuardian2Name(){
		return guardian2Name;
	}
	public String getAddress(){
		return address;
	}
	public String getDob1(){
		return dob1;
	}
	public String getDob2(){
		return dob2;
	}
/**
 *This is the toString() method.
 *It displays the values of the variables in a String.
 *
 *@author Oran Guthrie
 *@version 3
 *@since 16-Nov-2016
 */	
	public String toString(){
		return "Child Name: " + childName + "."
				+ "Guardian Names: " + guardian1Name + ", " + guardian2Name + "."
					+ "Address: " + address + "."
						+ "Date of Births: Adopter 1 " + dob1 + ", Adopter 2 " + dob2 + ".";
	}
}