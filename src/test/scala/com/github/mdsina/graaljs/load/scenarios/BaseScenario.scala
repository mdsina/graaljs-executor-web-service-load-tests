package com.github.mdsina.graaljs.load.scenarios

import com.github.mdsina.graaljs.load.cases.InfoNodeTest
import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.ScenarioBuilder

class BaseScenario(baseUrl: String, pacing: Map[String, Int], name:String, feeder: FeederBuilder) {

  private val scn: ScenarioBuilder = scenario(name)
    .forever(
      pace(pacing("CallV2"))
        .feed(feeder)
        .exec(InfoNodeTest(baseUrl))
    )
}

object BaseScenario {

  def apply(baseUrl: String, pacing: Map[String, Int], name:String, feeder: FeederBuilder): ScenarioBuilder = new BaseScenario(baseUrl, pacing, name, feeder).scn

}
