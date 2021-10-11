public class Reg_slot {
    private int no_of_slots, hospital_id;
    static int static_slot_number = 0;
    int slot_number;
    private Vaccine[] v;

    Reg_slot(){
        slot_number = static_slot_number;
        no_of_slots = hospital_id = 0;
    }
    Reg_slot(int hospital_id, int no_of_slots)
    {
        this.hospital_id = hospital_id;
        this.no_of_slots = no_of_slots;
        static_slot_number = static_slot_number + slot_number;
        this.slot_number = static_slot_number;
    }
    public void set_vaccine_obj(Vaccine[] v)
    {
        this.v = v;
    }
    public void set_no_of_doses(int no_of_doses, int index)
    {
        v[index].set_no_of_doses(no_of_doses);
    }
    public void set_day_no(int day_no, int index)
    {
        v[index].set_gap(day_no);
    }
    public void set_quantity(int j)
    {
        v[j].set_no_of_doses(v[j].get_no_of_doses() - 1);
    }
    public int get_slot_number()
    {
        return this.slot_number;
    }
    public int get_day(int index)
    {
        return v[index].get_gap();
    }
    public int get_quantity(int index)
    {
        return v[index].get_no_of_doses();
    }
    public String get_vaccine_name(int index)
    {
        return v[index].get_name();
    }
    public int get_number_of_slots()
    {
        return this.no_of_slots;
    }
    public int get_hospital_id()
    {
        return this.hospital_id;
    }
    public void print_data(Vaccine v)
    {
        System.out.println("Slot added by Hospital " + hospital_id + " for Day: " + v.get_gap() + ", Available Quantity: " + v.get_no_of_doses() + " of Vaccine " + v.get_name());
    }
    public void print_slots(){
        for(int j = 0; j<no_of_slots; j++)
        {
            System.out.println("Day: " + v[j].get_gap() + " Vaccine: " + v[j].get_name() + " Available Qty: " + v[j].get_no_of_doses());
        }
    }
}
