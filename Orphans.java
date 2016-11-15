//Orphans.java
/*This is the Orphans class for the Orphanage System.*/

public class Orphans{
	
	private String name;
	private String dob;
	private String hairColour;
	private String eyeColour;
	private char gender;
	private int roomNo;
	private int bedNo;
	private String arrivalDate;
	private String departureDate;	
	
	public Orphans(){
		name = "No Name Specified";
		dob = "dd/mm/YYYY";
		hairColour = "No Hair Colour Specified";
		eyeColour = "No Eye Colour Specified";
		gender = 0;
		roomNo = 0;
		bedNo = 0;
		arrivalDate = "dd/mm/YYYY";
		departureDate = "dd/mm/YYYY";	
	}
	
	public Orphans(String name, String dob, String hairColour, String eyeColour, char gender){
		this.name = name;
		this.dob = dob;
		this.hairColour = hairColour;
		this.eyeColour = eyeColour;
		this.gender = gender;		
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setDob(String dob){
		this.dob = dob;
	}
	public void setHairColour(String hairColour){
		this.hairColour = hairColour;
	}
	public void setEyeColour(String eyeColour){
		this.eyeColour = eyeColour;
	}
	public void setGender(char gender){
		this.gender = gender;
	}
	public void setRoomNo(int roomNo){
		this.roomNo = roomNo;
	}
	public void setBedNo(int bedNo){
		this.bedNo = bedNo;
	}
	public void setArrivalDate(String arrivalDate){
		this.arrivalDate = arrivalDate;
	}
	public void setDepartureDate(String departureDate){
		this.departureDate = departureDate;
	}	
	
	public String getName(){
		return name;
	}
	public String getDob(){
		return dob;
	}
	public String getHairColour(){
		return hairColour;
	}
	public String getEyeColour(){
		return eyeColour;
	}
	public char getGender(){
		return gender;
	}
	public int getRoomNo(){
		return roomNo;
	}
	public int getBedNo(){
		return bedNo;
	}
	public String getArrivalDate(){
		return arrivalDate;
	}
	public String getDepartureDate(){
		return departureDate;
	}
		
	public String toString(){
		return "Name: " + name + "."
				+ "\nDate of Birth: " + dob + "."
					+ "\nHair Colour: " + hairColour + "."
						+ "\nEye Colour: " + eyeColour + "."
							+ "Room Number: " + roomNo + "."
								+ "Bed Number: " + bedNo + "."
									+ "\nArrival Date: " + arrivalDate + "."
										+ "\nDepartureDate: " + departureDate + ".";
	}
}