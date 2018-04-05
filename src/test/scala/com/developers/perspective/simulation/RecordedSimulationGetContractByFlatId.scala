package com.developers.perspective.simulation

import com.developers.perspective.scenarios.CubicContractServiceGet
import io.gatling.core.Predef._

import scala.concurrent.duration._

class RecordedSimulationGetContractByFlatId extends Simulation {

  setUp(
    CubicContractServiceGet.getContractsByFlat.inject(
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