public class Vaccine {
    private String name;
    private int no_of_doses, gap;

    Vaccine(){
        name = "";
        no_of_doses = 0;
        gap = 0;
    }
    Vaccine(String name, int no_of_doses, int gap)
    {
        this.name = name;
        this.gap = gap;
        this.no_of_doses = no_of_doses;
    }
    public void set_name(String name)
    {
        this.name = name;
    }
    public void set_no_of_doses(int no_of_doses)
    {
        this.no_of_doses = no_of_doses;
    }
    public void set_gap(int gap)
    {
        this.gap = gap;
    }
    public String get_name()
    {
        return this.name;
    }
    public int get_no_of_doses()
    {
        return this.no_of_doses;
    }
    public int get_gap()
    {
        return this.gap;
    }
    public void print_data()
    {
        System.out.println("Vaccine Name: " + name + ", Number of Doses: " + no_of_doses + ", Gap Between Doses: " + gap);
    }
}