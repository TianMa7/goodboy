package Assignments;

public class As1_Crops {

    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;



    public As1_Crops(String n, double y, String u, double p) {
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;
    }


    @Override
    public String toString() {
        return "As1_Crops{" +
                "name='" + name + '\'' +
                ", yield=" + yield +
                ", units='" + units + '\'' +
                ", price=" + price +
                ", acres=" + acres +
                '}';
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }

    public String getName() {
        return name;
    }

    public double harvest(){
        double total = price*acres*yield;
        System.out.println("Harvest is: " + total);
        acres = 0;
        return total;
    }

    public void addAcres(int acres){
        this.acres += acres;
    }
}
