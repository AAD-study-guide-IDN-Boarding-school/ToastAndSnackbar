package com.example.toastandsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import com.example.toastandsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                binding.timer.text = getString(R.string.time_reamining, p0 / 1000)
            }

            override fun onFinish() {
                Snackbar.make(binding.root, "Waktu Sudah habis", Snackbar.LENGTH_LONG).setAction("Retry"){
                    countDownTimer.start()
                }.show()
            }
        }

        binding.btnStart.setOnClickListener {
            countDownTimer.start()
        }
    }
}