//Adoptions.java
/*This is the Adoptions class for the Orphanage System.*/

public class Adoptions{
	
	private String childName;
	private String adopter1Name;
	private String adopter2Name;
	private String address;
	private String dob1;
	private String dob2;
	private String adoptionDate;
	
	public Adoptions(){
		childName = "No Name Specified";
		adopter1Name = "No Name Specified";
		adopter2Name = "No Name Specified";
		address = "No Address Specified";
		dob1 = "dd/mm/YYYY";
		dob2 = "dd/mm/YYYY";
		adoptionDate = "dd/mm/YYYY";
	}
	
	public Adoptions(String childName, String adopter1Name, String adopter2Name, String address, String dob1, String dob2, String adoptionDate){
		this.childName = childName;
		this.adopter1Name = adopter1Name;
		this.adopter2Name = adopter2Name;
		this.address = address;
		this.dob1 = dob1;
		this.dob2 = dob2;
		this.adoptionDate = adoptionDate;
	}
	
	public void setChildName(String childName){
		this.childName = childName;
	}
	public void setAdopter1Name(String adopter1Name){
		this.adopter1Name = adopter1Name;
	}
	public void setAdopter2Name(String adopter2Name){
		this.adopter2Name = adopter2Name;
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
	public void setAdoptionDate(String adoptionDate){
		this.adoptionDate = adoptionDate;
	}
	
	public String getChildName(){
		return childName;
	}
	public String getAdopter1Name(){
		return adopter1Name;
	}
	public String getAdopter2Name(){
		return adopter2Name;
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
	public String adoptionDate(){
		return adoptionDate;
	}
	
	public String toString(){
		return "Child Name: " + childName + "."
				+ "Adopter Names: " + adopter1Name + ", " + adopter2Name + "."
					+ "Address: " + address + "."
						+ "Date of Births: Adopter 1 " + dob1 + ", Adopter 2 " + dob2 + "."
							+ "AdoptionDate: " + adoptionDate + ".";
	}
}