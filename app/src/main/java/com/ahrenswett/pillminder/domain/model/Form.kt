package com.ahrenswett.pillminder.domain.model

// Class for dropdown menu of medication forms
sealed class Form(val form: String) {
    object TABLET : Form("Tablet")

    object CAPSULE : Form("Capsule")

    object POWDER : Form("Powder")

    object HERB : Form("Herb")

    object TOPICAL : Form("Topical")

    object LIQUID : Form("Liquid")

    object SOLUTION : Form("Solution")

    object DROPS : Form("Drops")

    object INHALABLE : Form("Inhalable")

    object INJECTION : Form("Injection")

    object SUPPOSITORY : Form("Suppository")
}
