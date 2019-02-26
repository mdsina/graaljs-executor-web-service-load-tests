package com.github.mdsina.graaljs.load.cases

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

class InfoNodeTest(baseUrl: String) {

  private val request: HttpRequestBuilder = http("InfoNodeTest")
    .post(baseUrl + "/api/v1/script/TEST_${index}")
    .header("Content-Type", "application/json")
    .body(ElFileBody("templates/script.json")).asJson
    .check(status in 200)

  private val scn: ScenarioBuilder = scenario("InfoNodeTest")
    .exec(request)

}

object InfoNodeTest {

  def apply(baseUrl: String): ScenarioBuilder = new InfoNodeTest(baseUrl).scn

}
