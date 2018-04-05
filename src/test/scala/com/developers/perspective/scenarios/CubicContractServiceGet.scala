package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CubicContractServiceGet {

  val req = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ejb=\"http://ejb.webservice.volia.com/\">\n" +
    "   <soapenv:Header/>\n" +
    "   <soapenv:Body>\n" +
    "      <ejb:getHouseInfo>\n" +
    "         <houseId>607826647</houseId>\n" +
    "      </ejb:getHouseInfo>\n" +
    "   </soapenv:Body>\n</soapenv:Envelope>"

  val httpProtocol = http
    .baseURL("http://10.10.16.248:8888")
    .inferHtmlResources(BlackList(), WhiteList("""http://10.10.16.248:8888/contract-service/ContractService/"""))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    //    .disableFollowRedirect
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
    .contentTypeHeader("text/xml; charset=utf-8")

  val headers_0 = Map(
    "Authorization" -> "Basic c2VydmljZWRlc2s6bmF1MTM1MjQ=",
    "Content-Type" -> "text/xml; charset=utf-8"
  )

  val getCubicCS = http("request_1")
    .post("/contract-service/ContractService")
    .body(StringBody(req))
    .headers(headers_0)
    .check(status.is(session => 200))
    .check(bodyString.saveAs("RESPONSE_DATA"))

  val getCubicCS_another = http("request_2")
    .post("/contract-service/ContractService")
    .body(StringBody(req))
    .headers(headers_0)
    .check(status.is(session => 200))
    .check(bodyString.saveAs("RESPONSE_DATA"))

  val getInfo = scenario("Cubic_Get_CS")
    .exec(getCubicCS)

  val getInfo2 = scenario("Cubic_Get_CS2")
    .exec(getCubicCS_another)

  //  val scnSearch = Constants.createScenario("Search", csvFeeder,
  //    reqGoToHome, reqSearchProduct, reqGoToHome)

}
