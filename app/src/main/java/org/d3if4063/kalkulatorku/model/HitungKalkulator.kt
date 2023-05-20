package org.d3if4063.kalkulatorku.model

import org.d3if4063.kalkulatorku.db.KalkulatorEntity

fun KalkulatorEntity.hitungKalkulator(): HasilLuas {
    val kalkulator = panjang * lebar * tinggi

    return HasilLuas(kalkulator)
}