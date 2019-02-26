package com.github.mdsina.graaljs.load.tests

import com.github.mdsina.graaljs.load.scenarios.BaseScenario
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class MaxPerfTest extends Simulation {

  private val baseUrl = "http://localhost:9082"

  private val startRPS = 30
  private val steps = 0


  private val pacings = Map(
    "CallV1" -> 10,
    "CallV2" -> 10,
  )

  private val feeder = csv("pool/indices.csv").random

  setUp(

    BaseScenario(baseUrl, pacings, "Graal", feeder).inject(
      rampConcurrentUsers(500)
        .to(5000)
        .during(1 hour)
    )
  ).maxDuration(1000)
}
