package org.pignat.utils

import org.pignat.playgrounds.ForestFire

object Main {
  def main(args: Array[String]): Unit = {

    val f = Selector.select("ForestFire", new JvmDrawable)
    val t = 500

    while (true) {
      f.step(System.currentTimeMillis() / t)
      Thread.sleep(t)
    }
  }
}
