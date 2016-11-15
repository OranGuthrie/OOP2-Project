//OrphanageGUI.java
/*This program creates a GUI for the Orphanage System.*/

import javax.swing.*;

public class OrphanageGUI extends JFrame implements ActionListener{
	
	JMenu fileMenu, orphanMenu;
	Orphans[] orphans; //This gets saved to the file.
	
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
		
		createFileMenu();
		createOrphanMenu();
		
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
		
	}
}