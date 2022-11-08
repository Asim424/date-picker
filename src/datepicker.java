
import java.awt.Color;  
import java.awt.event.*;
import java.util.*;
import javax.swing.*;  
import javax.swing.JComponent.*;

class datepicker extends Thread{
	public boolean shouldcheck = true;
	public void run(){
		while(shouldcheck){
			if(dates.istoday("")){
				System.out.println("today");
				shouldcheck = false;
			}
		}
	}
	public static String dateinput = "";
	
	public static void main(String[] args) {
		datepicker test = new datepicker();
		test.start();
		JFrame frame = new JFrame("date reminder");
		//make a jframe
		JPanel panel = new JPanel();
		//make a jpanel
		JTextField io = new JTextField();//textfield will be to get what the user wants to remember
	//	make a text field
		String[] year = { "Select year","2021","2022", "2023", "2024", "2025", "2026","2027" };
		String[] month = {"Select month", "January", "February", "March", "April", "May","June" ,"July" ,"August" ,"September" ,"October" ,"November" ,"December"};
		String[] day = { "Select day","01", "02", "03", "04", "05","06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21","22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		JComboBox<String> years= new JComboBox<String>(year);
		JComboBox<String> months = new JComboBox<String>(month);
		JComboBox<String> days = new JComboBox<String>(day);
		JLabel toptext = new JLabel("choose a day you want to be reminded on");
		JButton confirmdate = new JButton("confirm date?");
//this is a change
		panel.add(confirmdate);
		panel.add(toptext);
		panel.add(years);		
		panel.add(months);		
		panel.add(days);
		frame.add(panel);  
		//adds the panel to the frame
		frame.setSize(1280,1024);    
		//sets the default size to 1280px X 1024px
		frame.setVisible(true);    
		//makes the frame visible
		panel.setLayout(null);
		years.setBounds(0,20,426,20);
		months.setBounds(426,20,426,20);
		days.setBounds(852,20,426,20);
		toptext.setBounds(550,0,1280,20);
		confirmdate.setBounds(550,50,150,20);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		
		//ui^
		//
		//
		//
		//action listeners
		confirmdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//yyyy/mm/dd (space) hh:MM:ss
				dateinput = (!years.getSelectedItem().equals("Select year")? years.getSelectedItem():0)+"/";
				dateinput+= (months.getSelectedIndex() <10 ? "0" + months.getSelectedIndex():months.getSelectedIndex())+"/";
				dateinput+= (!days.getSelectedItem().equals("Select day")? days.getSelectedItem():0)+"\n";
				System.out.println(dates.checkdupe(dateinput,true));
			}
		});
			
		months.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if((months.getSelectedIndex()+1)%2 == 1){
					days.removeItem("31");
					panel.revalidate();
					panel.repaint();
				}
				if((months.getSelectedIndex())%2 == 1){
					days.addItem("31");
					panel.revalidate();
					panel.repaint();
				}
				if(months.getSelectedItem().equals("February")){
					if(years.getSelectedIndex()%4!=0) {
						days.removeItem("31");
						days.removeItem("30");
						days.removeItem("29");
						panel.revalidate();
						panel.repaint();
					}else {
						days.removeItem("31");
						days.removeItem("30");
						days.removeItem("29");
						days.addItem("29");
					}
				}else {
					days.removeItem("31");
					days.removeItem("30");
					days.removeItem("29");
					days.addItem("29");
					days.addItem("30");
					days.addItem("31");
					
				}
			}
		});
		
		years.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(months.getSelectedItem().equals("February")){
					if(years.getSelectedIndex()%4!=0) {
						days.removeItem("31");
						days.removeItem("30");
						days.removeItem("29");
						panel.revalidate();
						panel.repaint();
					}else {
						days.removeItem("31");
						days.removeItem("30");
						days.removeItem("29");
						days.addItem("29");
					}
				}else {
					days.removeItem("31");
					days.removeItem("30");
					days.removeItem("29");
					days.addItem("29");
					days.addItem("30");
					days.addItem("31");
					
				}
			}
			
		});
	}
}