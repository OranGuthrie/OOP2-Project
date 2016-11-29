//OrphanageGUI.java
/*This program creates a GUI for the Orphanage System.*/

//SimpleDateFormat adoptionDate = new SimpleDateFormat("MMMM dd'th', yyyy");
//GregorianCalendar adoptionDate;
//adoptionDate = new GregorianCalendar();

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
	Container pane;
	
	public static void main(String args[]){
		OrphanageGUI frame = new OrphanageGUI();
		frame.setVisible(true);
	}
	
	public OrphanageGUI(){
		newSystem();
		
		setTitle("Orphanage System");
		setSize(900, 600);
		setLocation(100, 100);
		pane = getContentPane();		
		pane.setBackground(new Color(240, 210, 240));
		pane.setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createFileMenu();
		createOrphanMenu();
		createAdoptionMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(orphanMenu);
		menuBar.add(adoptionMenu);
	}
	
	public void newSystem(){
		orphans = new Orphans[24];
		adoptions = new Adoptions[24];
		count = 0;
		roomCount = 1;
		bedCount = 0;
	}
	
	public void addAdoption(){
		
		createAdoptionPanel();
		
		Adoptions adoption = new Adoptions();
		adoptions[count] = adoption;
		count++;		
	}
	
	public void createAdoptionPanel(){
		
		JFrame adoptionsGUI = new JFrame("Adoptions");
		adoptionsGUI.setSize(600, 500);
		adoptionsGUI.setLocation(200, 200);
		
		Container cpane = adoptionsGUI.getContentPane();
		
		cpane.setBackground(new Color(100, 210, 240));
		cpane.setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		panel.setBackground(new Color(100, 150, 125));
		panel.setSize(25,40);
		
		JLabel ltitle = new JLabel("Orphanage");
		cpane.add(ltitle);
		
		JLabel lcName = new JLabel(" Enter child's name: ");
		JLabel lguardian1Name = new JLabel(" Enter first guardian's name: ");
		JLabel lguardian2Name = new JLabel(" Enter second guardian's name: ");
		JLabel laddress = new JLabel(" Enter address: ");
		JLabel ldob1 = new JLabel(" Enter first guardian's date of birth: ");
		JLabel ldob2 = new JLabel(" Enter first guardian's date of birth: ");
		
		JTextField fcName = new JTextField(25);
		JTextField fguardian1Name = new JTextField(25);
		JTextField fguardian2Name = new JTextField(25);
		JTextField faddress = new JTextField(25);
		JTextField fdob1 = new JTextField(10);
		JTextField fdob2 = new JTextField(10);
		
		panel.add(lcName);
		panel.add(fcName);
		panel.add(lguardian1Name);
		panel.add(fguardian1Name);
		panel.add(lguardian2Name);
		panel.add(fguardian2Name);
		panel.add(laddress);
		panel.add(faddress);
		panel.add(ldob1);
		panel.add(fdob1);
		panel.add(ldob2);
		panel.add(fdob2);
		
		JButton jb = new JButton("Confirm");
		panel.add(jb);
		jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent Event){
            	adoptionsGUI.setVisible(false);
            	//Add data to array
         	}
      	});
		
		cpane.add(panel);
		adoptionsGUI.setVisible(true);
	}
	
	public void addOrphan(){
		
		createOrphanPanel();
		
		Orphans orphan = new Orphans();
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
      	
      	JOptionPane.showMessageDialog(null, orphans.toString());
	}
	
	public void createOrphanPanel(){

		JFrame orphansGUI = new JFrame("Orphans");
		orphansGUI.setSize(600, 500);
		orphansGUI.setLocation(200, 200);
		
		Container cpane = orphansGUI.getContentPane();
		
		cpane.setBackground(new Color(100, 210, 240));
		cpane.setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		panel.setBackground(new Color(100, 150, 125));
		panel.setSize(25,40);
		
		JLabel ltitle = new JLabel("Orphanage");
		cpane.add(ltitle);
		
		JLabel lname = new JLabel(" Enter child's name: ");
		JLabel ldob = new JLabel(" Enter child's date of birth: ");
		JLabel lhairColour = new JLabel(" Enter child's hair colour: ");
		JLabel leyeColour = new JLabel(" Enter child's eye colour: ");
		JLabel lgender = new JLabel(" Enter child's gender: ");
		
		JTextField fname = new JTextField(25);
		JTextField fdob = new JTextField(10);
		JTextField fhairColour = new JTextField(25);
		JTextField feyeColour = new JTextField(25);
		JTextField fgender = new JTextField(6);
		
		panel.add(lname);
		panel.add(fname);
		panel.add(ldob);
		panel.add(fdob);
		panel.add(lhairColour);
		panel.add(fhairColour);
		panel.add(leyeColour);
		panel.add(feyeColour);
		panel.add(lgender);
		panel.add(fgender);
		
		JButton jb = new JButton("Confirm");
		panel.add(jb);
		jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent Event){
            	orphansGUI.setVisible(false);
            	//Add data to array
         	}
      	});
		
		cpane.add(panel);
		orphansGUI.setVisible(true);
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
													+ "\nRoom Number: " + roomCount + "."//Displays 0
														+ "\nBed Number: " + bedCount + ".\n");//Displays 0
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
      	if(e.getActionCommand().equals("Quit")){
      		showMessage("Quitting");
      		System.exit(0);
      	}
      	
      	else if(e.getActionCommand().equals("Add Orphan")){
      	    addOrphan();
      	}
      	
      	else if(e.getActionCommand().equals("Display Orphans")){
            displayList();
      	}
      	
      	else if(e.getActionCommand().equals("New Orphan File")){
      		newSystem();
        }
      	
      	else if(e.getActionCommand().equals("Save File")){
      		try{
      	 		save();
      	 		showMessage("Data Saved Successfully");
      	}
      	
      	catch(IOException f){
      	 		showMessage("Save Unsuccessful");
      	 		f.printStackTrace();
      		}
      	}
    	
    	else if(e.getActionCommand().equals("Open Orphan File")){
      		open();
        	displayList();
      	}
      	
      	else if(e.getActionCommand().equals("New Adoption")){
      	    addAdoption();
      	}
      	
      	else if(e.getActionCommand().equals("Display Adoptions")){
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