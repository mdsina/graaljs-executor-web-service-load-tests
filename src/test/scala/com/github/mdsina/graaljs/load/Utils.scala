package com.github.mdsina.graaljs.load

import scala.util.Random

object Utils {

  class RoundCounter(min: Int, max: Int, step:Int){

    private var current = 0

    def apply(): Int = {

      if (current < max ) {
        current += step
        current
      }else{
        current  = min
        current
      }
    }

    def getRandom(): Int = {
      Random.nextInt(max)+min
    }
  }


  def getCounter(min: Int, max: Int, step:Int): RoundCounter = {
    new RoundCounter(min, max, step)
  }
}
