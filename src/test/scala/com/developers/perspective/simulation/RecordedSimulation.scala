package com.developers.perspective.simulation

import com.developers.perspective.scenarios.CubicContractServiceGet
import io.gatling.core.Predef._

import scala.concurrent.duration._

class RecordedSimulation extends Simulation {

  setUp(
    CubicContractServiceGet.getInfo.inject(
      rampUsersPerSec(0) to 50 during (5 seconds), // 3
      constantUsersPerSec(50) during (10 seconds), // 4
    )
      .protocols(CubicContractServiceGet.httpProtocol)
  )
    .assertions(
      //      global.responseTime.max.lte(5000),
      global.successfulRequests.percent.gte(98)
    )
}


//  val httpProtocol = http
//    .baseURL("http://10.10.16.248:8888")
//    .inferHtmlResources(BlackList(), WhiteList("""http://10.10.16.248:8888/contract-service/ContractService/"""))
//    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//    .acceptEncodingHeader("gzip, deflate")
//    //    .disableFollowRedirect
//    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
//    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
//    .contentTypeHeader("text/xml; charset=utf-8")
//
//  val headers_0 = Map(
//    "Authorization" -> "Basic c2VydmljZWRlc2s6bmF1MTM1MjQ=",
//    "Content-Type" -> "text/xml; charset=utf-8"
//  )
//
//  //  val headers_1 = Map("Upgrade-Insecure-Requests" -> "1")
//  //
//  //  //	val headers_3 = Map("Accept" -> "text/css,*/*;q=0.1")
//  //  //	val headers_8 = Map("Accept" -> "*/*")
//  //  //    val uri1 = "10.10.16.246"
//
//  val scn = scenario("RecordedSimulation")
//    .exec(http("request_1")
//      .post("/contract-service/ContractService")
//      .body(StringBody(req))
//      .headers(headers_0)
//      .check(status.is(session => 200))
//        .check(bodyString.saveAs("RESPONSE_DATA"))
//      //      .resources(http("request_2")
//      //        .get("/")
//      //        .headers(headers_1),
//      //        http("request_3")
//      //          .get("/gitblt-favicon.png")))
//      //    .pause(1)
//    ).exec( session => {
//    println( "Some Restful Service:" )
//    println( session( "RESPONSE_DATA" ).as[String] )
//    session
//  })
//
//
//  System.out.println("${RESPONSE_DATA}" + "***************************")
//
//  setUp(
//    scn.inject(
//      nothingFor(4 seconds), // 1
//      atOnceUsers(3), // 2
//      rampUsersPerSec(3) to 10 during (5 seconds), // 3
//      constantUsersPerSec(10) during (10 seconds), // 4
//      constantUsersPerSec(20) during (15 seconds) randomized, // 5
//      rampUsersPerSec(20) to 50 during (3 minutes), // 6
//      rampUsersPerSec(10) to 20 during (10 minutes) randomized, // 7
//      splitUsers(1000) into (rampUsers(10) over (10 seconds)) separatedBy (10 seconds), // 8
//      splitUsers(1000) into (rampUsers(10) over (10 seconds)) separatedBy atOnceUsers(30), // 9
//      heavisideUsers(1000) over (20 seconds) // 10
//    ).protocols(httpProtocol)
//  )
//  //  setUp(scn.inject(atOnceUsers(500))).protocols(httpProtocol)  // запуск 500 пользователей за раз
//  //  setUp(scn.inject(rampUsers(500) over(100 seconds))).protocols(httpProtocol) // запуск  500 пользователей за 100 сек
//}
//
//
////val scn = scenario("RecordedSimulation")
////  .exec(http("request_1")
////    .get("/commit/volia-auto-testing.git/")
////    .check(status.is(session => 302))
////    .check(bodyString.saveAs("RESPONSE_DATA"))
////    .headers(headers_1)
////    .resources(http("request_2")
////      .get("/")
////      .headers(headers_1),
////      http("request_3")
////        .get("/gitblt-favicon.png")))
////  .pause(1)
////  .exec(http("request_4")
////    .get("/repositories/")
////    .headers(headers_1))
////  .exec(session => {
////    println("Some Restful Service:")
////    println(session("${RESPONSE_DATA}").as[String])
////    session
////  })