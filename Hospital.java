
public class Hospital{
    private String name, pincode;
    private static int st_id = 0;
    private int id;

    Hospital(){
        name = "";
        pincode = "";
    }
    Hospital(String name, String pincode)
    {
        this.name = name;
        this.pincode = pincode;
        this.id = st_id;
        st_id+=1;
    }
    public String get_name()
    {
        return this.name;
    }
    public String get_pincode()
    {
        return this.pincode;
    }
    public int get_id()
    {
        return this.id;
    }
    public void print_data()
    {
        String id = "00000";
        id = id + Integer.toString(this.id);
        System.out.println("Hospital Name: " + name + ", PinCode: " + pincode + ", Unique ID: " + id.substring(id.length() - 6));
    }
}
