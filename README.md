# PillMinder
Simple pill reminder app that is persistant at reminding the user(s) to take or Administer medication.


| MainScreen | List screen |
| --- | --- |
| <img src="https://github.com/ahrenswett/PillMinder/blob/main/readme_res/main.png?raw=true" width="200" /> | <img src="https://github.com/ahrenswett/PillMinder/blob/main/readme_res/list.png?raw=true" width="200" /> |

## MVP for this project
- Add and delete delete cabinets to and from the database.
- Add and delete bottles to and from the database and cabinets.
  - Bottles have prescriptions, doses, and consumables
- CRUD for Reminders
- CRUD for Consumables
- List of Upcoming reminders for the day

## 1 Stretch: Add users and cloud access.
AWS Dynamo?


## 2 Stretch: 
User should have a list of cabinets they can access i.e. (pets childrens partner client patients

/* should a App Users have designations in cabinets such as access rights? I.E.
Prescriber
READ/WRITE
- medications and dosages.
READ
- User's name and info
- Usage history
- all personal cabinet contents wither or not they where the prescribing doc.  
User
READ/WRITE
- medications and dosages should notify prescriber if changed as saftey precaution
READ
- User's name and info
- Usage history
- all personal cabinet contents wither or not they where the prescribing doc.
Care Giver