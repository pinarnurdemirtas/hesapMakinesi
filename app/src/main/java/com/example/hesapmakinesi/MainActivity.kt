package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.hesapmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bir.appendClick("1")
            iki.appendClick("2")
            uc.appendClick("3")
            dort.appendClick("4")
            bes.appendClick("5")
            alti.appendClick("6")
            yedi.appendClick("7")
            sekiz.appendClick("8")
            dokuz.appendClick("9")
            sifir.appendClick("0")
            nokta.appendClick(".")
            esittir.appendClick("=")
            eksi.appendClick("-")
            arti.appendClick("+")
            carpi.appendClick("*")
            bolu.appendClick("/")
            ac.setOnClickListener {
                binding.sonuc.text = null
                binding.islem.text = ""
            }
            esittir.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(binding.sonuc.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()){
                        binding.islem.text = longResult.toString()
                    }else{
                        binding.islem.text = result.toString()
                    }

                }catch (e:Exception){
                    Log.d("Exception", "Message: ${e.message}")
                }
            }

        }

    }
    private fun View.appendClick(string: String){
        setOnClickListener{
            binding.sonuc.append(string)
        }

    }

}