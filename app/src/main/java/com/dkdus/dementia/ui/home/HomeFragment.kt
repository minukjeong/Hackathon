package com.dkdus.dementia.ui.home

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dkdus.dementia.R
import com.dkdus.dementia.model.Item
import com.dkdus.dementia.ui.DetailActivity
import com.dkdus.dementia.ui.game.RcpActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory


class HomeFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    lateinit var viewModel: HomeViewModel
    private lateinit var mMap: GoogleMap
    var lat : NodeList? = null
    var lot : NodeList? = null
    var cntername : NodeList? = null
    var lnmadr : NodeList? = null
    var imbcltyIntrcn : NodeList? = null
    var call : NodeList? = null
    var doctorN : NodeList? = null
    var nurseN : NodeList? = null
    var sabokN : NodeList? = null
    var data: MutableList<Item> = arrayListOf()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        placeCall()
    }

    private fun placeCall() {
        viewModel.callPlace().observe(viewLifecycleOwner, Observer {
            var xpath: XPath = XPathFactory.newInstance().newXPath()

            lat = xpath.evaluate(
                "//body/items/item/latitude",
                it, XPathConstants.NODESET
            ) as NodeList?
            lot = xpath.evaluate(
                "//body/items/item/longitude",
                it, XPathConstants.NODESET
            ) as NodeList?
            cntername = xpath.evaluate(
                "//body/items/item/cnterNm",
                it, XPathConstants.NODESET
            ) as NodeList?
            lnmadr = xpath.evaluate(
                "//body/items/item/lnmadr",
                it, XPathConstants.NODESET
            ) as NodeList?
            imbcltyIntrcn = xpath.evaluate(
                "//body/items/item/imbcltyIntrcn",
                it, XPathConstants.NODESET
            ) as NodeList?
            call = xpath.evaluate(
                    "//body/items/item/phoneNumber",
                    it, XPathConstants.NODESET
            ) as NodeList?
            doctorN = xpath.evaluate(
                    "//body/items/item/doctrCo",
                    it, XPathConstants.NODESET
            ) as NodeList?
            nurseN = xpath.evaluate(
                    "//body/items/item/nurseCo",
                    it, XPathConstants.NODESET
            ) as NodeList?
            sabokN = xpath.evaluate(
                    "//body/items/item/scrcsCo",
                    it, XPathConstants.NODESET
            ) as NodeList?

            Log.d("수렴","receive")

            for(i in 0..lat?.length!!-1){

            mMap.addMarker(
                MarkerOptions().position(LatLng(lat!!.item(i).textContent.toDouble(), lot?.item(i)?.textContent!!.toDouble()))
                    .title(cntername!!.item(i).textContent)
                        .zIndex(i.toFloat())
            )}
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lat!!.item(0).textContent.toDouble(), lot?.item(0)?.textContent!!.toDouble()),7f))
        })
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        val marker = LatLng(35.241615, 128.695587)
    //    mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))

        mMap.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        var index = p0!!.zIndex.toInt()

        var intent: Intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("lat",lat!!.item(index).textContent)
        intent.putExtra("lot",lot!!.item(index).textContent)
        intent.putExtra("cntername",cntername!!.item(index).textContent)
        intent.putExtra("lnmadr",lnmadr!!.item(index).textContent)
        intent.putExtra("imbcltyIntrcn",imbcltyIntrcn!!.item(index).textContent)
        intent.putExtra("call",call!!.item(index).textContent)
        intent.putExtra("doc",doctorN!!.item(index).textContent)
        intent.putExtra("nur",nurseN!!.item(index).textContent)
        intent.putExtra("sabok",sabokN!!.item(index).textContent)
        startActivity(intent)
        return true
    }

}