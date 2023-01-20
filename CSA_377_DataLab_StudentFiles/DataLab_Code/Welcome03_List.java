import java.util.ArrayList;
import java.util.Scanner;
import core.data.*;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      
      // Find the southernmost weather station in the given state
      WeatherStation southernmost = null;
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state) && (southernmost == null || ws.getLatitude() < southernmost.getLatitude())) {
            southernmost = ws;
         }
      }
      
      System.out.println("Stations in " + state);
      if (southernmost != null) {
         System.out.println("Southernmost station: " + southernmost.getId() + " - " + southernmost.getName() + " located at " + southernmost.getLatitude() + " latitude.");
  } else {
System.out.println("No station found in the given state");
}
}
}
