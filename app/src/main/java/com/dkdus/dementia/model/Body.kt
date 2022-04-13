package com.dkdus.dementia.model

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper

data class Body(
    @field:XmlElementWrapper(name = "items")
    @field:XmlElement(name = "item")
    var items : List<Item>? = arrayListOf(),
    var numOfRows : String? = "0",
    var pageNo : String? = "1",
    var totalCount : String? = "0"

)
