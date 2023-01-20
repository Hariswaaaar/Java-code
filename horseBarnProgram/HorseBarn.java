import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HorseBarn {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<Horse> horses = new ArrayList<Horse>();
    
    // Read the list of horses from the file horsedata.txt
    Scanner in = new Scanner(new File("/workspace/Java-code/horseBarnProgram/horsedata.txt"));
    while (in.hasNextLine()) {
      String line = in.nextLine();
      String[] parts = line.split(",");
      String name = parts[0];
      int weight = Integer.parseInt(parts[1]);
      Horse h = new Horse(name, weight);
      horses.add(h);
    }
    in.close();
    
    // Get a randomly ordered version of the list of horses
    ArrayList<Horse> shuffled = RandomPermutation.next(horses);
    
    // Display pairs of horses
    for (int i = 0; i < shuffled.size(); i += 2) {
      Horse h1 = shuffled.get(i);
      Horse h2 = (i + 1 < shuffled.size()) ? shuffled.get(i + 1) : null;
      if (h2 == null) {
        System.out.println(h1.getName() + " does not have a partner.");
      } else {
        System.out.println(h1.getName() + " and " + h2.getName());
      }
    }
  }
  
  public static class Horse {
    private String name;
    private int weight;
    
    public Horse(String name, int weight) {
      this.name = name;
      this.weight = weight;
    }
    
    public String getName() {
      return name;
    }
  }
  
  public static class RandomPermutation {
    public static ArrayList<Horse> next(ArrayList<Horse> horses) {
      ArrayList<Horse> result = new ArrayList<Horse>();
      ArrayList<Horse> temp = new ArrayList<Horse>(horses);
      
      while (!temp.isEmpty()) {
        int pos = (int) (Math.random() * temp.size());
        result.add(temp.remove(pos));
      }
      
      return result;
    }
  }
}







