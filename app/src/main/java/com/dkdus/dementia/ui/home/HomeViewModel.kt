package com.dkdus.dementia.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dkdus.dementia.model.Item
import com.dkdus.dementia.model.Items
import com.dkdus.dementia.util.PlaceUtil
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

class HomeViewModel : ViewModel() {
    fun callPlace() : MutableLiveData<Document>{
        val placeUtil = PlaceUtil()
        var data: MutableLiveData<Document> = MutableLiveData()
        placeUtil.getApi().getPlace("100","xml")
            .enqueue(object : Callback<String>{
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Fail~~~",t.message.toString())
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
                    var builder : DocumentBuilder = factory.newDocumentBuilder()
                    var ins : InputSource = InputSource(StringReader(response.body()))
                    var document : Document =  builder.parse(ins)
             //       var xpath : XPath = XPathFactory.newInstance().newXPath()
                    data.value = document
             //       var cols = xpath.evaluate("//body/items/item/latitude",
             //           document,XPathConstants.NODESET) as NodeList?

                }
            })

        return data
    }
}

