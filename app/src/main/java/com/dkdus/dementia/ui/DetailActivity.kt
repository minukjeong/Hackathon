package com.dkdus.dementia.ui

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dkdus.dementia.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    var marker : LatLng? = null
    var docContainer : LinearLayout? = null
    var nurseContainer : LinearLayout? = null
    var sabokContainer : LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map_detail) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        docContainer = findViewById(R.id.docN)
        nurseContainer = findViewById(R.id.nurseN)
        sabokContainer = findViewById(R.id.sabokN)

        if(intent!=null){
            var name = intent.getStringExtra("cntername")
            var lat = intent.getStringExtra("lat").toString()
            var lot = intent.getStringExtra("lot").toString()
            var addr = intent.getStringExtra("lnmadr")//주소
            var programShow = intent.getStringExtra("imbcltyIntrcn")//주요치매관리프로그램소개
            var phoneNum = intent.getStringExtra("call")
            var docN = intent.getStringExtra("doc")
            var nurN = intent.getStringExtra("nur")
            var sabokN = intent.getStringExtra("sabok")

            title = name

            tv_addrV.text = addr
            tv_programValue.text = programShow
            tv_callV.text = phoneNum
            doctorIcon(docN!!.toInt())
            nurseIcon(nurN!!.toInt())
            socialIcon(sabokN!!.toInt())
            marker = LatLng(lat.toDouble(), lot.toDouble())
        }
    }

    private fun doctorIcon(n:Int){
        for(i in 0..n){
            var v1 = ImageView(this)
            v1.setImageResource(R.drawable.doctor_icon)
            var lp = LinearLayout.LayoutParams(70, 70)
            v1.layoutParams = lp
            docContainer!!.addView(v1)
        }
    }

    fun nurseIcon(n:Int){
        for(i in 0..n){
            var v2 = ImageView(this)
            v2.setImageResource(R.drawable.icon_nurse)
            var lp = LinearLayout.LayoutParams(70, 70)
            v2.layoutParams = lp
            nurseContainer!!.addView(v2)
        }
    }
    fun socialIcon(n:Int){
        for(i in 0..n){
            var v3 = ImageView(this)
            v3.setImageResource(R.drawable.icon_social)
            var lp = LinearLayout.LayoutParams(70, 70)
            v3.layoutParams = lp
            sabokContainer!!.addView(v3)
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        mMap.addMarker(MarkerOptions().position(marker!!)
                .title(title.toString()))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 9f))
    }


}