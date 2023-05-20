package org.d3if4063.kalkulatorku.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.d3if4063.kalkulatorku.db.KalkulatorDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriViewModel(private val db: KalkulatorDao) : ViewModel() {
    val data = db.getLastKalkulator()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}