package com.ahrenswett.pillminder.domain.model

//@Entity(tableName = "users")
//@Serializable
//data class User(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo (name = "id") val id : Int,
//    @ColumnInfo (name = "username") val username : String,
//    @ColumnInfo (name = "first_name") val firstname: String,
//    @ColumnInfo (name = "last_name") val lastname: String

// a user should have a list of cabinets the can access i.e. (pets childrens partner client patients

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
 */


//

//)

