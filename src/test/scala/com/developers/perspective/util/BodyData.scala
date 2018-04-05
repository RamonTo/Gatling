package com.developers.perspective.util

object BodyData {
  val getHouseInfo = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ejb=\"http://ejb.webservice.volia.com/\">\n" +
    "   <soapenv:Header/>\n" +
    "   <soapenv:Body>\n" +
    "      <ejb:getHouseInfo>\n" +
    "         <houseId>607826647</houseId>\n" +
    "      </ejb:getHouseInfo>\n" +
    "   </soapenv:Body>\n</soapenv:Envelope>"

  val getContractsByFlatId = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ejb=\"http://ejb.webservice.volia.com/\">\n" +
    " <soapenv:Header/>\n" +
    " <soapenv:Body>\n" +
    "   <ejb:getContractsByFlatId>\n" +
    "     <flatId>27212200</flatId>\n" +
    "     <userId>1</userId>\n" +
    "   </ejb:getContractsByFlatId>\n" +
    " </soapenv:Body>\n" +
    " </soapenv:Envelope>"

}
