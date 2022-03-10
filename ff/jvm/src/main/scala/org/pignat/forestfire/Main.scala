package org.pignat.forestfire

import java.time.Instant


object Main {
  def main(args: Array[String]): Unit = {
    val w = new JvmDrawable
    w.test()
    val f = new ForestFire(w)
    val t = 10

    while (true) {
      f.step(System.currentTimeMillis() / t)
      Thread.sleep(t)
    }
  }
}

