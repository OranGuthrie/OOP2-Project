//OrphanageGUI.java
/*This program creates a GUI for the Orphanage System.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.text.*;
import java.util.*;

public class OrphanageGUI extends JFrame implements ActionListener{
	
	JMenu fileMenu, orphanMenu;
	Orphans[] orphans; //This gets saved to the file.
	int count;
	
	public static void main(String args[]){
		OrphanageGUI frame = new OrphanageGUI();
		frame.setVisible(true);
	}
	
	public OrphanageGUI(){
		newSystem();
		
		setTitle("Orphanage System");
		setSize(300, 200);
		setLocation(100, 100);
		Container pane = getContentPane();
		
		pane.setBackground(new Color(240, 210, 240));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//createFileMenu();
		//createOrphanMenu();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(orphanMenu);
	}
	
	public void newSystem(){
		orphans = new Orphans[25];
		count = 0;
	}
	
	public void addOrphan(){
		String name = JOptionPane.showInputDialog("Enter child's name: ");
		String dob = JOptionPane.showInputDialog("Enter child's date of birth: ");
		String hairColour = JOptionPane.showInputDialog("Enter child's hair colour: ");
		String eyeColour = JOptionPane.showInputDialog("Enter child's eye colour: ");
		char gender = JOptionPane.showInputDialog("Enter child's gender: ").charAt(0);
		
		Orphans orphan = new Orphans(name, dob, hairColour, eyeColour, gender);
		
		orphans[count] = orphan;
		count++;
		
		//SimpleDateFormat convictionDate = new SimpleDateFormat("MMMM dd'th', yyyy");	
        //GregorianCalendar convictionDate;
      	//convictionDate = new GregorianCalendar();
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
												+ "\nGender: " + orphans[i].getGender() + ".");
				
				}
			}	
			showMessage(area);
		}
		
		else
			showMessage("No orphans in the system.");
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
      	 	JOptionPane.showMessageDialog(null, "Unable to open");
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
      	
      	else if(e.getActionCommand() .equals ("Save Orphan File")){
      		try{
      	 		save();
      	 		showMessage("Data saved successfully");
      	}
      	
      	catch(IOException f){
      	 		showMessage("Save unsuccessful");
      	 		f.printStackTrace();
      		}
      	}
    	
    	else if(e.getActionCommand() .equals ("Open Orphan File")){
      		open();
        	displayList();
      	}
      	
      	else
      	 	showMessage("Unknown Input");
        }
        
	private void createFileMenu(){  
      	fileMenu = new JMenu("File");
        //Creates New Orphan Option
      	JMenuItem item;
      	item = new JMenuItem("New Orphan File");
      	item.addActionListener(this);
      	fileMenu.add(item);
	   	//Creates Open Orphan Option
      	item = new JMenuItem("Open Orphan File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	//Creates Save Orphan Option     	
      	item = new JMenuItem("Save Orphan File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	//Adds separator between options    
      	fileMenu.addSeparator();
      	//Creates Quit Option
      	item = new JMenuItem("Quit");
        item.addActionListener(this);
      	fileMenu.add(item);
    }

    private void createOrphanMenu(){   
      	orphanMenu = new JMenu("Orphan");
    
      	JMenuItem item;

      	item = new JMenuItem("Add Orphan");
      	item.addActionListener(this);
      	orphanMenu.add(item);

      	item = new JMenuItem("Display Orphans");
      	item.addActionListener(this);
      	orphanMenu.add(item);
    }
    
    public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
    }

    public void showMessage (JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }
}