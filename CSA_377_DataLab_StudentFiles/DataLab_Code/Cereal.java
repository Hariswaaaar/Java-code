public class Cereal {
    // instance variables
    private String name;
    private String type;
    private double price;
    private int calories;

    // constructors
    public Cereal() {
        this("Unknown", "Unknown", 0.0, 0);
    }

    public Cereal(String name, String type, double price, int calories) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.calories = calories;
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    // toString method
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Price: $" + price + ", Calories: " + calories;
    }

    // main method for testing
    public static void main(String[] args) {
        Cereal cereal1 = new Cereal("Cheerios", "Whole Grain", 2.99, 110);
        Cereal cereal2 = new Cereal("Frosted Flakes", "Sugar", 3.49, 120);
        Cereal cereal3 = new Cereal("Honeycomb", "Sugar", 2.89, 130);

        System.out.println(cereal1);
        System.out.println(cereal2);
        System.out.println(cereal3);
    }
}
