# Cowin
A Command Line app that facilitates vaccination system.

----------------------------------------------------------------------------------------------------------------------
                                          Different tasks to perform:


  1. Add Vaccine:
    Input: Name, Number of total doses required, Gap Between Doses
    Output: Display the added vaccine details
    
  2. Register Hospital:
    Input: Name, Pincode
    Output: Display the added hospital details along with the generated unique hospital
    ID (A 12 digit number)
    
  3. Register Citizen:
    Input: Name, Age, Unique ID (A 12 digit numeric ID like Aadhar ID)
    Output: Display the citizen details and set his/her vaccination status as "REGISTERED."
    
  4. Create Slots:
    Input: Hospital ID followed by the number of slots that the hospital wants to add. For each slot, enter the day number and quantity followed by selecting the vaccine for
      that slot.
    Output: Display the details of the added slot.
    
  5. Book a Slot:
    Input: Unique ID of the citizen followed by 2 options to search: {By Pincode, By Vaccine}. A successful search should show a list of possible hospitals. Upon selecting
      the chosen hospital, their available slots must be reflected, and a chosen slot must be booked.
    Output: Display the citizen vaccinated along with the vaccine. Change the status of the citizen to PARTIALLY VACCINATED/FULLY VACCINATED accordingly.
    
  6. Slots available with a hospital
    Input: Hospital ID
    Output: List all slots for the chosen hospital

  7. Check vaccination status:
    Input: Citizen inputs his/her Unique ID to check current status
    Output: Display the current vaccination status: REGISTERED/PARTIALLY VACCINATED/FULLY VACCINATED along with the vaccine administered, number of doses given, and the due date         of next vaccination (in case of partial vaccination).
    
----------------------------------------------------------------------------------------------------------------------
