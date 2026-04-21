package com.example.t3_mobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rbPerempuan)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)

        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {

            val nama = etNama.text.toString()

            // VALIDASI NAMA
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // VALIDASI GENDER
            if (rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = if (rbLaki.isChecked) "Laki-laki" else "Perempuan"

            // AMBIL HOBI
            val listHobi = ArrayList<String>()

            if (cbMembaca.isChecked) listHobi.add("Membaca")
            if (cbCoding.isChecked) listHobi.add("Coding")
            if (cbOlahraga.isChecked) listHobi.add("Olahraga")

            val hobi = if (listHobi.isNotEmpty()) {
                listHobi.joinToString(", ")
            } else {
                "Tidak ada"
            }

            // TAMPILKAN HASIL
            val hasil = """
                Nama    : $nama
                Kelamin : $gender
                Hobi    : $hobi
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}