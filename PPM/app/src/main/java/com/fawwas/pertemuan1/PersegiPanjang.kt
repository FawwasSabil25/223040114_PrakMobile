package com.fawwas.pertemuan1

fun main(args: Array<String>){
    val panjang = 4
    val lebar = 2

    val persegiPanjang = PersegiPanjang(panjang, lebar)
    println("Panjang: $panjang")
    println("Lebar: $lebar")
    println("Luas: ${persegiPanjang.hitungLuas()}")
    println("Keliling: ${persegiPanjang.hitungKeliling()}")
}

class PersegiPanjang(private val panjang: Int, private val lebar: Int) {
    fun hitungLuas(): Int{
        return panjang * lebar
    }

    fun hitungKeliling(): Int{
        return 2 * (panjang + lebar)
    }
}