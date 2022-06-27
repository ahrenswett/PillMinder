# PillMinder
PillMinder is a reminder/usage Tracking app for Medications and Supplements. It is very good about being persistent to user specifications regarding the reminders. For example, when a reminder pops up it will do so in full screen. If meds were taken a user can hold the checkmark for a few seconds logging the dose as taken. Where as clicking the dismiss/ snooze will ask again after a specified time.
Users will have the ability to share cabinets with others and have multiple cabinets of their own in case of children / pets / Significant others who depend on them for tracking / administering. 


App Screens as of 06/27/2022
| Cabinet List (Main) Screen | Cabinet View screen | 
| --- | --- |
| <img src="https://github.com/ahrenswett/PillMinder/blob/main/readme_res/main_screen.png?raw=true" width="200" /> | <img src="https://github.com/ahrenswett/PillMinder/blob/main/readme_res/cabinet_view.png?raw=true" width="200" /> |


## MVP:
  - CRUD (Create read update delete) for Cabinets, Bottles, Prescriptions, and Reminders.
### Main View (CabinetList)
  - [x] Has a `FloatingActionButton` " + " that takes the user to a view that allows them to add a new cabinet.
  - [ ] Swiping right on a Cabinet will give option to delete. Delete will be confirmed and allow snackbar with undo capability.
  - [x] Shows list of cabinets with a + mark to add bottles to that cabinet.
  - [x] Clicking on Cabinet takes users to a CabinetView.
### Cabinet View
  - [x] Displays Cabinet Name in TopBar.
  - [x] Has a `FloatingActionButton` " + " that takes the user to a view that allows them to add a new Bottle.
  - [ ] Shows list of current Bottles in the Cabinet in a CabinetItem.
  - [ ] Swiping right on a Bottle will give option to delete. Delete will be confirmed and allow snackbar with undo capability.
### Reminders
  - [ ] Can set a reminder from the AddEditBottleView.
  - [ ] Can set the number of times to be reminded in a day to take same Consumable. As well as the spacing interval.
  - [ ] Can set snooze length.
  - [ ] Auto log missed doses after a set time.
  
## Secondary Goals
User Login - Cloud persistence - Cabinet sharing with read/write permissions.
### Main View (CabinetList)
  - [ ] Cabinet screen should differentiate between personal, children's, pets, Significant Others, and shared cabinets.
### Cabinet View
  - [ ] Implement Tabular View that separates Medications from Supplements.
### Menu
  - [ ] Add a menu.

## Fluff Goals: 

## Things to Consider
- Should a App Users have designations in cabinets such as access rights? I.E.
  - Prescriber
    - READ/WRITE 
      - A Patients medications and dosages. 
    - READ
      - User's name and info
      - All Bottles owned by User wither or not they where the prescribing doc.
      - Usage history
  - User
    - READ/WRITE
      - Cabinets and Cabinet names
      - Medications and dosages. If changed should notify all prescribers as safety precaution 
      - - Usage history ?
    - READ
      - Users name and info 
      - Usage history ?
      