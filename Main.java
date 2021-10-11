import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException, java.lang.Exception
    {
        ArrayList<Vaccine> arr_vac = new ArrayList<Vaccine>();
        ArrayList<Hospital> arr_hos = new ArrayList<Hospital>();
        ArrayList<Citizen> arr_cit = new ArrayList<Citizen>();
        ArrayList<Reg_slot> arr_regslot = new ArrayList<Reg_slot>();
        Reader.init(System.in);
        System.out.println("CoWin Portal initialized....");
        while(true)
        {
            System.out.println("---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            int choice = Reader.nextint();
            if(choice == 1)
            {
                String name;
                int no_of_doses, gap = 0;
                System.out.print("Vaccine Name: ");
                name = Reader.nextline();
                System.out.print("Number of Doses: ");
                no_of_doses = (Reader.nextint());
                if(no_of_doses > 1){
                    System.out.print("Gap between Doses: ");
                    gap = (Reader.nextint());
                }
                Vaccine v = new Vaccine(name, no_of_doses, gap);
                v.print_data();
                if(no_of_doses < 1)
                {
                    System.out.println("Enter valid number of doses");
                    continue;
                }
                if(gap < 0)
                {
                    System.out.println("Enter valid number of gaps");
                    continue;
                }
                arr_vac.add(v);
            }
            if(choice == 2)
            {
                String name, pincode;
                System.out.print("Hospital Name: ");
                name = (Reader.nextline());
                System.out.print("PinCode: ");
                pincode = (Reader.nextline());
                int flag = 0;
                Hospital h = new Hospital(name, pincode);
                h.print_data();
                for(int i = 0; i<arr_hos.size(); i++) //checking if duplicate name and pincode
                {
                    Hospital temp_hos = new Hospital();
                    temp_hos = arr_hos.get(i);
                    if(temp_hos.get_name().equals(name) && temp_hos.get_pincode().equals(pincode))
                    {
                        System.out.println("Hospital already exists.");
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                    arr_hos.add(h);
            }
            if(choice == 3)
            {
                int age;
                long id;
                String name;
                System.out.print("Citizen Name: ");
                name = (Reader.nextline());
                System.out.print("Age: ");
                age = (Reader.nextint());
                System.out.print("Unique ID: ");
                String check = Reader.next();
                int flag = 0;
                if(check.length() == 12)
                    id = (Long.parseLong(check));
                else{
                    id = (Long.parseLong(check));
                    flag = 1;
                }
                for(int i = 0; i<arr_cit.size(); i++) //checking if duplicate name
                {
                    Citizen temp_cit = new Citizen();
                    temp_cit = arr_cit.get(i);
                    if(temp_cit.get_id() == id)
                    {
                        flag = 2;
                        break;
                    }
                }
                Citizen c = new Citizen(name, age, id);
                c.print_data();
                if(flag == 1){
                    System.out.println("Enter a valid citizen ID");
                    continue;
                }
                if(flag == 2)
                {
                    System.out.println("Citizen already exists.");
                    continue;
                }
                if(c.get_age() < 18)
                    System.out.println("Only above 18 are allowed");
                else
                    arr_cit.add(c);
            }
            if(choice == 4)
            {
                int no_of_slots, hospital_id;
                Vaccine[] v;
                System.out.print("Enter Hospital ID: ");
                hospital_id = (Reader.nextint());
                System.out.print("Enter number of Slots to be added: ");
                no_of_slots = (Reader.nextint());
                v = new Vaccine[no_of_slots];
                int flag = 0;
                for(Hospital i : arr_hos)
                {
                    if(i.get_id() == hospital_id)
                        flag = 1;
                }
                if(flag == 0)
                {
                    flag = 1;
                    System.out.println("Enter a valid Hospital ID.");
                    continue;
                }
                Reg_slot rs = new Reg_slot(hospital_id, no_of_slots);
                for(int i = 0; i<no_of_slots; i++){
                    v[i] = new Vaccine();
                    System.out.print("Enter Day Number: ");
                    v[i].set_gap(Reader.nextint());
                    System.out.print("Enter Quantity: ");
                    v[i].set_no_of_doses(Reader.nextint());
                    System.out.println("Select Vaccine : ");
                    for(int j = 0; j<arr_vac.size(); j++)
                    {
                        System.out.println(j + ". " + arr_vac.get(j).get_name());
                    }
                    int temp = Reader.nextint();
                    if(temp < arr_vac.size() && temp >= 0)
                        v[i].set_name((arr_vac.get(temp)).get_name());
                    else
                    {
                        flag = 2;
                        System.out.println("Select a valid Vaccine.");
                        break;
                    }
                    rs.print_data(v[i]);
                    //rs.set_vaccine_obj(v);
                }
                if(flag == 2)
                    continue;
                rs.set_vaccine_obj(v);
                arr_regslot.add(rs);
            }
            if(choice == 5)
            {
                long patient_id;
                System.out.print("Enter patient Unique ID: ");
                patient_id = Reader.nextlong();
                Citizen temp_cit = new Citizen();
                int flag = 0;
                for(Citizen iter : arr_cit)
                {
                    if(patient_id == iter.get_id()){
                        temp_cit = iter;
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    System.out.println("Citizen id is invalid");
                    continue;
                }
                if(temp_cit.get_status().equals("FULLY VACCINATED"))
                {
                    System.out.println("The person is fully vaccinated.");
                    continue;
                }
                System.out.println("1. Search by area\n2. Search by Vaccine\n3. Exit");
                int temp;
                System.out.print("Enter option: ");
                temp = Reader.nextint();
                if(temp == 1)
                {
                    String pin;
                    System.out.print("Enter PinCode: ");
                    pin = Reader.nextline();
                    for(Hospital temp_hos : arr_hos)
                    {
                        if(temp_hos.get_pincode().equals(pin))
                        {
                            String s = "00000" + String.valueOf(temp_hos.get_id());
                            System.out.println(s.substring(s.length()-6) + " " + temp_hos.get_name());
                        }
                    }
                    System.out.print("Enter hospital id: ");
                    int id = Reader.nextint();
                    int checker = 0;
                    for(Reg_slot temp_reg : arr_regslot)
                    {
                        if(temp_reg.get_hospital_id() == id)
                        {
                            if(temp_reg.get_number_of_slots() > 0)
                            {
                                for(int i = temp_reg.get_slot_number(), j = 0; j<temp_reg.get_number_of_slots(); j++, i++)
                                {
                                    if(temp_cit.get_due_date() <= temp_reg.get_day(j) && (temp_cit.get_vacc_taken_name().equals("-1") || temp_cit.get_vacc_taken_name().equals(temp_reg.get_vaccine_name(j))))
                                    {
                                        checker = 1;
                                        System.out.println(i + "-> Day: " + temp_reg.get_day(j) + " Available Qty:" + temp_reg.get_quantity(j) + " Vaccine:" + temp_reg.get_vaccine_name(j));
                                    }
                                }
                                if(checker == 0){
                                    break;
                                }
                                System.out.print("Choose Slot: ");
                                int choice2 = Reader.nextint();
                                for(int i = temp_reg.get_slot_number(), j = 0; j<temp_reg.get_number_of_slots(); j++, i++)
                                {
                                    if(temp_cit.get_due_date() <= temp_reg.get_day(j) && (temp_cit.get_vacc_taken_name().equals("-1") || temp_cit.get_vacc_taken_name().equals(temp_reg.get_vaccine_name(j))))
                                    {
                                        if(i == choice2)
                                        {
                                            int due = 0,total = 0;
                                            for(Vaccine itr : arr_vac)
                                            {
                                                if(temp_reg.get_vaccine_name(j) == itr.get_name()){
                                                    due = itr.get_gap();
                                                    total = itr.get_no_of_doses();
                                                }
                                            }
                                            temp_reg.set_quantity(j);
                                            temp_cit.set_vacc_taken_name(temp_reg.get_vaccine_name(j));
                                            temp_cit.set_due_date(temp_reg.get_day(j) + due);
                                            temp_cit.set_total_doses_taken();
                                            if(temp_cit.get_total_doses_taken() == total)
                                                temp_cit.set_status("FULLY VACCINATED");
                                            else
                                                temp_cit.set_status("PARTIALLY VACCINATED");
                                            System.out.println(temp_cit.get_name() + " vaccinated with " + temp_reg.get_vaccine_name(j));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(checker == 0){
                        System.out.println("No slots available");
                    }
                }
                else if(temp == 2)
                {
                    String Vaccine;
                    System.out.print("Enter Vaccine name: ");
                    Vaccine = Reader.nextline();
                    for(Reg_slot temp_hos : arr_regslot)
                    {
                        for(int i = 0; i<temp_hos.get_number_of_slots(); i++){
                            if(temp_hos.get_vaccine_name(i).equals(Vaccine))
                            {
                                String hos_name = "";
                                for(Hospital k : arr_hos)
                                {
                                    if(temp_hos.get_hospital_id() == k.get_id()){
                                        hos_name = k.get_name();
                                        break;
                                    }
                                }
                                String s = "00000" + String.valueOf(temp_hos.get_hospital_id());
                                System.out.println(s.substring(s.length() - 6) + " " + hos_name);
                            }
                        }
                    }   
                    System.out.print("Enter hospital id: ");
                    int id = Reader.nextint();
                    int checker = 0;
                    for(Reg_slot temp_reg : arr_regslot)
                    {
                        if(temp_reg.get_hospital_id() == id)
                        {
                            if(temp_reg.get_number_of_slots() > 0)
                            {
                                for(int i = temp_reg.get_slot_number(), j = 0; j<temp_reg.get_number_of_slots(); j++, i++)
                                {
                                    if(temp_cit.get_due_date() <= temp_reg.get_day(j) && (temp_cit.get_vacc_taken_name().equals("-1") || temp_cit.get_vacc_taken_name().equals(temp_reg.get_vaccine_name(j))) && temp_reg.get_quantity(j) > 0){
                                        System.out.println(i + "-> Day: " + temp_reg.get_day(j) + " Available Qty:" + temp_reg.get_quantity(j) + " Vaccine:" + temp_reg.get_vaccine_name(j));
                                        checker = 1;
                                    }
                                }
                                if(checker == 0){
                                    break;
                                }
                                System.out.print("Choose Slot: ");
                                int choice2 = Reader.nextint();
                                for(int i = temp_reg.get_slot_number(), j = 0; j<temp_reg.get_number_of_slots(); j++, i++)
                                {
                                    if(temp_cit.get_due_date() <= temp_reg.get_day(j) && (temp_cit.get_vacc_taken_name().equals("-1") || temp_cit.get_vacc_taken_name().equals(temp_reg.get_vaccine_name(j))))
                                    {
                                        if(i == choice2)
                                        {
                                            int due = 0,total = 0;
                                            for(Vaccine itr : arr_vac)
                                            {
                                                if(temp_reg.get_vaccine_name(j) == itr.get_name()){
                                                    due = itr.get_gap();
                                                    total = itr.get_no_of_doses();
                                                }
                                            }
                                            temp_reg.set_quantity(j);
                                            temp_cit.set_vacc_taken_name(temp_reg.get_vaccine_name(j));
                                            temp_cit.set_due_date(temp_reg.get_day(j) + due);
                                            temp_cit.set_total_doses_taken();
                                            if(temp_cit.get_total_doses_taken() == total)
                                                temp_cit.set_status("FULLY VACCINATED");
                                            else
                                                temp_cit.set_status("PARTIALLY VACCINATED");
                                            System.out.println(temp_cit.get_name() + " vaccinated with " + temp_reg.get_vaccine_name(j));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(checker == 0){
                        System.out.println("No slots available");
                    }
                }
                else if(temp == 3)
                {
                    break;
                }
                else
                {
                    System.out.println("Enter a valid choice");
                }
            }
            if(choice == 6)
            {
                int hos_id;
                int flag = 0;
                System.out.print("Enter Hospital Id: ");
                hos_id = Reader.nextint();
                for(int i = 0; i<arr_regslot.size(); i++)
                {
                    if(arr_regslot.get(i).get_hospital_id() == hos_id)
                    {
                        Reg_slot temp_reg = arr_regslot.get(i);
                        temp_reg.print_slots();
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                {
                    System.out.println("No slots available");
                }
            }
            if(choice == 7)
            {
                long patient_id;
                System.out.print("Enter patient Unique ID: ");
                patient_id = Reader.nextlong();
                Citizen temp_cit = new Citizen();
                int flag = 0;
                for(Citizen iter : arr_cit)
                {
                    if(patient_id == iter.get_id()){
                        temp_cit = iter;
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    System.out.println("Citizen id is invalid");
                    continue;
                }
                if(temp_cit.get_status().equals("Registered")){
                    System.out.println("Citizen " + temp_cit.get_status());
                    continue;
                }
                else
                    System.out.println(temp_cit.get_status());
                System.out.println("Vaccine Given: " + temp_cit.get_vacc_taken_name());
                System.out.println("Number of Doses given: " + temp_cit.get_total_doses_taken());
                if(!temp_cit.get_status().equals("FULLY VACCINATED"))
                    System.out.println("Next Dose due date: " + temp_cit.get_due_date());
            }
            if(choice == 8)
                break;
        }
    }    
}





















class Reader{
    
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String nextline() throws IOException {
        return reader.readLine();
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TO DO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static float nextfloat() throws IOException {
        return Float.parseFloat( next() );
    }

    static Boolean nextboolean() throws IOException {
        return Boolean.parseBoolean( next() );
    }
    
}


/*       END OF CODE         */