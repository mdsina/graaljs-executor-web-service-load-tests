package com.github.mdsina.graaljs.load.tests

import com.github.mdsina.graaljs.load.scenarios.BaseScenario
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class SmokeTest extends Simulation{

  private val baseUrl = "http://localhost:9082"

  private val pacings = Map(
    "CallV1" -> 1,
    "CallV2" -> 1,
  )

  private val feeder = csv("pool/indices.csv").random

  setUp(

    BaseScenario(baseUrl, pacings, "BaseScenario", feeder).inject(
      incrementConcurrentUsers(1)
        .times(1)
        .eachLevelLasting(30 seconds)
        .startingFrom(2)
    )
  ).maxDuration(5 minutes)

}
