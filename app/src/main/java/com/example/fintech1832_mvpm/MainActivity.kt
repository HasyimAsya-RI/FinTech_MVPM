package com.example.fintech1832_mvpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var etInputSatu:   EditText
    private lateinit var etInputDua:    EditText
    private lateinit var btnTambah:     Button
    private lateinit var btnKurang:     Button
    private lateinit var btnKali:       Button
    private lateinit var btnBagi:       Button
    private lateinit var txtHasil:      TextView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        val factory = object: ViewModelProvider.Factory {
            override fun <T: ViewModel?> create( modelClass: Class<T> ): T {
                return MainViewModel() as T
            }
        }
        mainViewModel = ViewModelProvider( this, factory )[MainViewModel::class.java]
        etInputSatu   = findViewById( R.id.eTxt_angkaPertama )
        etInputDua    = findViewById( R.id.eTxt_angkaKedua )
        btnTambah     = findViewById( R.id.btn_tambah )
        btnKurang     = findViewById( R.id.btn_kurang )
        btnKali       = findViewById( R.id.btn_kali )
        btnBagi       = findViewById( R.id.btn_bagi )
        txtHasil      = findViewById( R.id.txt_hasil )

        mainViewModel.result.observe( this ) { result ->
            etInputSatu.setText( "" )
            etInputDua.setText( "" )
            txtHasil.text = result.toString()
        }
        btnTambah.setOnClickListener {
            mainViewModel.addition(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnKurang.setOnClickListener {
            mainViewModel.subtraction(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnKali.setOnClickListener {
            mainViewModel.multiplication(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnBagi.setOnClickListener {
            mainViewModel.division(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
    }
}