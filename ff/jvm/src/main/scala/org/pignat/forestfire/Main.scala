package org.pignat.forestfire

import java.time.Instant


object Main {
  def main(args: Array[String]): Unit = {
    val w = new JvmDrawable
    w.test()
    val f = new ForestFire(w)

    while (true) {
      f.step(System.currentTimeMillis() / 10)
      Thread.sleep(10)
    }
  }
}
