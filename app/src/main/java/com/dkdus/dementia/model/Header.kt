package com.dkdus.dementia.model

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "header")
data class Header(
    var resultCode : String?="0",
    var resultMsg : String?=""
)