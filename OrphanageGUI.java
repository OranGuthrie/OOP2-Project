//OrphanageGUI.java
/*This program creates a GUI for the Orphanage System.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class OrphanageGUI extends JFrame implements ActionListener{
	
	JMenu fileMenu, orphanMenu, adoptionMenu;
	JPanel panel;
	Orphans[] orphans;
	Adoptions[] adoptions;
	int count, roomCount, bedCount;
	
	public static void main(String args[]){
		OrphanageGUI frame = new OrphanageGUI();
		frame.setVisible(true);
	}
	
	public OrphanageGUI(){
		newSystem();
		
		setTitle("Orphanage System");
		setSize(900, 600);
		setLocation(100, 100);
		Container pane = getContentPane();		
		pane.setBackground(new Color(240, 210, 240));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createFileMenu();
		createOrphanMenu();
		createAdoptionMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(orphanMenu);
		menuBar.add(adoptionMenu);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(240, 210, 240));
	}
	
	public void newSystem(){
		orphans = new Orphans[24];
		adoptions = new Adoptions[24];
		count = 0;
		roomCount = 1;
		bedCount = 0;
	}
	
	public void addAdoption(){
		String childName = JOptionPane.showInputDialog("Enter child's name: ");
		String guardian1Name = JOptionPane.showInputDialog("Enter the first guardian's name: ");
		String guardian2Name = JOptionPane.showInputDialog("Enter the second guardian's name: ");
		String address = JOptionPane.showInputDialog("Enter the adopter's address: ");
		String dob1 = JOptionPane.showInputDialog("Enter the Date of Birth for the first guardian: ");
		String dob2 = JOptionPane.showInputDialog("Enter the Date of Birth for the second guardian: ");
		
		Adoptions adoption = new Adoptions(childName, guardian1Name, guardian2Name, address, dob1, dob2);
		
		adoptions[count] = adoption;
		count++;		
		
		//SimpleDateFormat convictionDate = new SimpleDateFormat("MMMM dd'th', yyyy");
        //GregorianCalendar convictionDate;
      	//convictionDate = new GregorianCalendar();
	}
	
	public void addOrphan(){
		JLabel name = new JLabel("Enter Child Name: ");
		JLabel dob = new JLabel("Enter child's date of birth: ");
		JLabel hairColour = new JLabel("Enter child's hair colour: ");
		JLabel eyeColour = new JLabel("Enter child's eye colour: ");
		JLabel gender = new JLabel("Enter child's gender: ").charAt(0);
		
		Orphans orphan = new Orphans(name, dob, hairColour, eyeColour, gender);
		
		orphans[count] = orphan;
		count++;
		bedCount++;
		
		if(bedCount == 5){
			roomCount++;
			bedCount = 1;
		}
		
		if(roomCount == 6 & bedCount >= 1){
			JOptionPane.showMessageDialog(null, "No Vacancies Available.");
		}
		
		//SimpleDateFormat arrivalDate = new SimpleDateFormat("MMMM dd'th', yyyy");	
        //GregorianCalendar arrivalDate;
      	//arrivalDate = new GregorianCalendar();
      	
      	JOptionPane.showMessageDialog(null, "Name: " + name + "."
      											+ "\nDate of Birth: " + dob + "."
      												+ "\nHair Colour: " + hairColour + "."
      													+ "\nEye Colour: " + eyeColour + "."
      														+ "\nGender: " + gender + "."
      															+ "\nRoom Number: " + roomCount + "."
      																+ "\nBed Number: " + bedCount + ".");
	}
	
	public void displayList(){
		JTextArea area = new JTextArea();
		area.setText("Orphans List: ");
		
		if(orphans[0] != null){
			for(int i = 0; i < orphans.length; i++){
				if(orphans[i] != null){
					area.append("\nName: " + orphans[i].getName() + "."
									+ "\nDate of Birth: " + orphans[i].getDob() + "."
										+ "\nHair Colour: " + orphans[i].getHairColour() + "."
											+ "\nEye Colour: " + orphans[i].getEyeColour() + "."
												+ "\nGender: " + orphans[i].getGender() + "."
													+ "\nRoom Number: " + orphans[i].getRoomNo() + "."//Displays 0
														+ "\nBed Number: " + orphans[i].getBedNo() + ".\n");//Displays 0
				
				}
			}	
			showMessage(area);
		}
		
		else
			showMessage("No orphans in the system.");
	}
	
	public void displayAdoptions(){
		JTextArea area = new JTextArea();
		area.setText("Adoptions List: ");
		
		if(adoptions[0] != null){
			for(int i = 0; i < adoptions.length; i++){
				if(adoptions[i] != null){
					area.append("\nChild Name: " + adoptions[i].getChildName() + "."
									+ "\nGuardian Names: " + adoptions[i].getGuardian1Name() + ", " + adoptions[i].getGuardian2Name() + "."
										+ "\nAddress: " + adoptions[i].getAddress() + "."
											+ "\nFirst Guardian's Date Of Birth: " + adoptions[i].getDob1() + "."
												+ "\nSecond Guardian's Date Of Birth: " + adoptions[i].getDob2() + ".\n");
				
				}
			}	
			showMessage(area);
		}
		
		else
			showMessage("No adoptions in the system.");
	}
	
	public void save() throws IOException{
      	ObjectOutputStream oos;
      	oos = new ObjectOutputStream(new FileOutputStream ("orphans.dat"));
      	oos.writeObject(orphans);
      	oos.close();
    }
      
    public void open(){
      	count = 0;
      	 
      	try{
      	   ObjectInputStream ois;
      	   ois = new ObjectInputStream(new FileInputStream ("orphans.dat"));
           orphans  = (Orphans []) ois.readObject();
      	   ois.close(); 
       	}
      	
      	catch(Exception e){
      	 	JOptionPane.showMessageDialog(null, "Unable to open, no orphans in system.");
      		e.printStackTrace();
      	}
      	
      	while (orphans[count] != null)
      	    count++;
   }
      
   public void actionPerformed (ActionEvent e){
      	if(e.getActionCommand() .equals ("Quit")){
      		showMessage("Quitting");
      		System.exit(0);
      	}
      	
      	else if(e.getActionCommand() .equals ("Add Orphan")){
      	    addOrphan();
      	}
      	
      	else if(e.getActionCommand() .equals ("Display Orphans")){
            displayList();
      	}
      	
      	else if(e.getActionCommand() .equals ("New Orphan File")){
      		newSystem();
        }
      	
      	else if(e.getActionCommand() .equals ("Save File")){
      		try{
      	 		save();
      	 		showMessage("Data Saved Successfully");
      	}
      	
      	catch(IOException f){
      	 		showMessage("Save Unsuccessful");
      	 		f.printStackTrace();
      		}
      	}
    	
    	else if(e.getActionCommand() .equals ("Open Orphan File")){
      		open();
        	displayList();
      	}
      	
      	else if(e.getActionCommand() .equals ("New Adoption")){
      	    addAdoption();
      	}
      	
      	else if(e.getActionCommand() .equals ("Display Adoptions")){
            displayAdoptions();
      	}
      	
      	else
      	 	showMessage("Unknown Input");
        }
        
	private void createFileMenu(){
      	fileMenu = new JMenu("File");

      	JMenuItem item;
      	item = new JMenuItem("New Orphan File");
      	item.addActionListener(this);
      	fileMenu.add(item);

      	item = new JMenuItem("Open Orphan File");
      	item.addActionListener(this);
      	fileMenu.add(item);
   	
      	item = new JMenuItem("Save File");
      	item.addActionListener(this);
      	fileMenu.add(item);
 
      	fileMenu.addSeparator();

      	item = new JMenuItem("Quit");
        item.addActionListener(this);
      	fileMenu.add(item);
    }

    private void createOrphanMenu(){
      	orphanMenu = new JMenu("Orphans");
    
      	JMenuItem item;

      	item = new JMenuItem("Add Orphan");
      	item.addActionListener(this);
      	orphanMenu.add(item);

      	item = new JMenuItem("Display Orphans");
      	item.addActionListener(this);
      	orphanMenu.add(item);
    }
    
    private void createAdoptionMenu(){
      	adoptionMenu = new JMenu("Adoptions");
    
      	JMenuItem item;

      	item = new JMenuItem("New Adoption");
      	item.addActionListener(this);
      	adoptionMenu.add(item);

      	item = new JMenuItem("Display Adoptions");
      	item.addActionListener(this);
      	adoptionMenu.add(item);
    }
    
    public void showMessage(String s){
      	JOptionPane.showMessageDialog(null,s);
    }

    public void showMessage(JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }
}