package com.fawwas.pertemuan1

fun main(){
    println("Masukkan nilai :")
    val input = readLine() ?: ""
    val nilaiList = input.split(" ").map { it.toIntOrNull() ?: 0 } //kalo bukan Int jadi null trs diubah ke 0

    for (nilai in nilaiList){
        val indeksNilai = IndeksNilaiMatkul(nilai)
        val hasil = indeksNilai.getIndeks()
        println("Nilai: $nilai -> Indeks: $hasil")
    }
}

class IndeksNilaiMatkul(private val nilai: Int) {
    fun getIndeks(): String{
        return when{
            nilai in 80..100 -> "A"
            nilai in 70..79 -> "AB"
            nilai in 60..69 -> "B"
            nilai in 50..59 -> "BC"
            nilai in 40..49 -> "C"
            nilai in 30..39 -> "D"
            nilai in 0..29 -> "E"
            else -> "Nilai diluar jangkauan"
        }
    }
}