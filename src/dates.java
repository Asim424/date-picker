import java.time.*;
import java.time.format.*;
import java.io.*;
import java.util.*;

class dates {
	public static ZonedDateTime now = ZonedDateTime.now(ZoneId.of("MST7MDT"));
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static String formattedDateTime = now.format(formatter);
	public static String[] datetime = formattedDateTime.split(" ");
	//splits time up into date and time, date = 0, time = 1
	public static boolean checkdupe(String date, boolean shouldwrite) {
		boolean isduped = false;
		//gets time now
		//makes a formatter
		//makes the time a string
		try{
			// System.out.println(datetime[0]);
			File saveddates = new File(".//src//saved.txt");
			if(saveddates.createNewFile()) {
				FileWriter writer = new FileWriter(".//src//saved.txt",true);
				writer.write("date (time) message\n");
				// System.out.println("woo");
				writer.close();
			}
			FileWriter writer = new FileWriter(".//src//saved.txt",true);
			Scanner filereader = new Scanner(saveddates);
			while(filereader.hasNextLine()){
				String a = filereader.nextLine();
				// System.out.println(date+"   "+a);
				if(a.equals(date)){
					isduped = true;
					// System.out.println("same");
				}
			}
			
			if(!isduped&&shouldwrite) {
				writer.write(date);
			}
			
			writer.close();
			filereader.close();
		}catch(Exception e){
			
		}
		return isduped;
  }
  public static boolean istoday(String date){
	if(!date.equals("")){
		if(checkdupe(date,false)){
			System.out.println("today is "+date);
			return true;
		}
	}else{
		if(checkdupe(datetime[0],false)){
			System.out.println("today is "+date);
			return true;
		}
	}
	return false;
  }
}