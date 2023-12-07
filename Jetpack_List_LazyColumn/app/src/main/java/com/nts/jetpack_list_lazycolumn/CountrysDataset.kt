package com.nts.jetpack_list_lazycolumn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveCountrys() : SnapshotStateList<CountryModel_Data>{

    val countryList = remember {
        mutableStateListOf(
            CountryModel_Data(1,"India","This is The India Flag",R.drawable.india),
            CountryModel_Data(2,"IceLand","This is The IceLand Flag",R.drawable.iceland),
            CountryModel_Data(3,"NorthKorea","This is The NorthKorea Flag",R.drawable.northkorea),
            CountryModel_Data(4,"UnitedState","This is The UnitedState Flag",R.drawable.unitedstates),
            CountryModel_Data(5,"Canada","This is The Canada Flag",R.drawable.canada),
            CountryModel_Data(6,"Bhutan","This is The Bhutan Flag",R.drawable.bhutanese),
            CountryModel_Data(7,"Turkey","This is The Turkey Flag",R.drawable.turkey),
            CountryModel_Data(8,"Panama","This is The Panama Flag",R.drawable.panama),
            CountryModel_Data(9,"Algeria","This is The Algeria Flag",R.drawable.algeria),
            CountryModel_Data(10,"Georgia ","This is The Georgia  Flag",R.drawable.georgia),
        )
    }
        return countryList
}