package com.dkdus.dementia.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dkdus.dementia.R
import kotlinx.android.synthetic.main.fragment_check.*
import kotlinx.android.synthetic.main.fragment_check.view.*
import java.util.*
import android.speech.tts.TextToSpeech.ERROR


class CheckFragment : Fragment() {
    var total = 0
    lateinit var tts : TextToSpeech
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_check, container, false)

        tts = TextToSpeech(context, TextToSpeech.OnInitListener {
            if (it != ERROR) {
                tts.setLanguage(Locale.KOREAN)
            }
        })

        root.tv1.setOnClickListener {
            read(tv1.text.toString())
        }
        root.tv2.setOnClickListener {
            read(tv2.text.toString())
        }
        root.tv3.setOnClickListener {
            read(tv3.text.toString())
        }
        root.tv4.setOnClickListener {
            read(tv4.text.toString())
        }
        root.tv5.setOnClickListener {
            read(tv5.text.toString())
        }
        root.tv6.setOnClickListener {
            read(tv6.text.toString())
        }
        root.tv7.setOnClickListener {
            read(tv7.text.toString())
        }
        root.tv8.setOnClickListener {
            read(tv8.text.toString())
        }
        root.tv9.setOnClickListener {
            read(tv9.text.toString())
        }
        root.tv10.setOnClickListener {
            read(tv10.text.toString())
        }
        root.tv11.setOnClickListener {
            read(tv11.text.toString())
        }
        root.tv12.setOnClickListener {
            read(tv12.text.toString())
        }
        root.tv13.setOnClickListener {
            read(tv13.text.toString())
        }
        root.tv14.setOnClickListener {
            read(tv14.text.toString())
        }
        root.tv15.setOnClickListener {
            read(tv15.text.toString())
        }
        root.tv16.setOnClickListener {
            read(tv16.text.toString())
        }
        root.tv17.setOnClickListener {
            read(tv17.text.toString())
        }
        root.tv18.setOnClickListener {
            read(tv18.text.toString())
        }
        root.tv19.setOnClickListener {
            read(tv19.text.toString())
        }
        root.tv20.setOnClickListener {
            read(tv20.text.toString())
        }
        root.master_btn.setOnClickListener{
            master_btn.setEnabled(false)
            if (check1.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check2.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check3.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check4.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check5.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check6.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check7.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check8.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check9.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check10.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check11.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check12.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check13.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check14.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check15.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check16.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check17.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check18.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check19.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if (check20.isChecked()) {
                total++
                root.master_btn.setEnabled(true)
            }
            if(total > 10)
                showDialog()

            result.setText("결과 : " + total.toString() + "점 입니다.")
            total = 0
        }
        return root
    }

    private fun showDialog(){
        var ad = AlertDialog.Builder(context)
        ad.setTitle("진단결과").setMessage("10점 이상으로 치매가 의심됩니다. 가까운 센터를 방문해보세요.")
                .setNegativeButton("확인",
                        DialogInterface.OnClickListener { dialog, which ->
                        })
        ad.create().show()
    }

    private fun read(st : String){
        tts.speak(st, TextToSpeech.QUEUE_FLUSH,null)
    }
}