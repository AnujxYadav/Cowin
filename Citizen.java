public class Citizen{
    private int age;
    private long id;
    private int due_date, total_doses_taken;
    private String vacc_taken_name;
    private String name, status;
    
    Citizen(){
        id = age = 0;
        name = "";
        status = "Registered";
        due_date = 0;
        vacc_taken_name = "-1";
        total_doses_taken = 0;
    }
    Citizen(String name, int age, long id){
        this.name = name;
        this.age = age;
        this.id = id;
        this.status = "Registered";
        due_date = 0;
        vacc_taken_name = "-1";
        total_doses_taken = 0;
    }
    public void set_status(String status)
    {
        this.status = status;
    }
    public void set_due_date(int date)
    {
        this.due_date = date;
    }
    public void set_total_doses_taken()
    {
        this.total_doses_taken = this.total_doses_taken + 1;
    }
    public void set_vacc_taken_name(String vacc_taken_name)
    {
        this.vacc_taken_name = vacc_taken_name;
    }
    public int get_total_doses_taken()
    {
        return this.total_doses_taken;
    }
    public long get_id()
    {
        return this.id;
    }
    public int get_age()
    {
        return this.age;
    }
    public String get_name()
    {
        return this.name;
    }
    public String get_vacc_taken_name()
    {
        return this.vacc_taken_name;
    }
    public String get_status()
    {
        return this.status;
    }
    public int get_due_date()
    {
        return this.due_date;
    }
    public void print_data()
    {
        System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: " + id);
    }
}
