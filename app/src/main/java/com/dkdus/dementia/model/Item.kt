package com.dkdus.dementia.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
data class Item(
    var cnterNm: String?="0",
    var cnterSe: String?="0",
    var rdnmadr: String?="0",
    var lnmadr: String?="0",
    var latitude: String?="0",
    var longitude: String?="0",
    var fondYm: String?="0",
    var bildngAr: String?="0",
    var etcFclty: String?="0",
    var doctrCo: String?="0",
    var nurseCo: String?="0",
    var scrcsCo: String?="0",
    var etcHnfSttus: String?="0",
    var operInstitutionNm: String?="0",
    var rprsntvNm: String?="0",
    var operPhoneNumber: String?="0",
    var operCnsgnDate: String?="0",
    var imbcltyIntrcn: String?="0",
    var phoneNumber: String?="0",
    var institutionNm: String?="0",
    var referenceDate : String?="0",
    var insttCode :String?="0"

)