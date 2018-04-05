package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetUserByLastName {

  val getUserByLastNameHttp = http("get user by lastName")
    .get("/search/findByLastName")
    .queryParam("lastName", "Java")
    .check(status.is(200))

  val getUserByLastName = scenario("Get user by last name")
     .exec(
       getUserByLastNameHttp
     )
}
