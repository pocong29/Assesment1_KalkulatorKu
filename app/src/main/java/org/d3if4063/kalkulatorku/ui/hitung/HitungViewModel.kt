package org.d3if4063.kalkulatorku.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.d3if4063.kalkulatorku.db.KalkulatorDao
import org.d3if4063.kalkulatorku.db.KalkulatorEntity
import org.d3if4063.kalkulatorku.model.HasilLuas
import org.d3if4063.kalkulatorku.model.hitungKalkulator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: KalkulatorDao) : ViewModel() {
    private val hasilLuas = MutableLiveData<HasilLuas?>()

    fun hitungLuas(panjang: Float, tinggi: Float, lebar: Float, jenis : String) {
        val dataKalkulator = KalkulatorEntity(
            panjang = panjang,
            tinggi = tinggi,
            lebar = lebar,
            jenis = jenis,
        )
        hasilLuas.value = dataKalkulator.hitungKalkulator()

        val hasilBangunRuang = (panjang * lebar * tinggi)
        hasilLuas.value = HasilLuas(hasilBangunRuang)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                db.insert(dataKalkulator)
            }
        }

    }

    fun getHasilLuas(): LiveData<HasilLuas?> = hasilLuas
}