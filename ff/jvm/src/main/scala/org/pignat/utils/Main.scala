package org.pignat.utils

import org.pignat.playgrounds.ForestFire

object Main {
  def main(args: Array[String]): Unit = {
    val n = if (args.length == 0) "" else args(0)
    if (n == "-h" || n == "--help") {
      println("use an experiment as parameter, " + Selector.usage())
      return
    }
    val f = Selector.select(n, new JvmDrawable)
    val t = 50

    while (true) {
      f.step(System.currentTimeMillis() / t)
      Thread.sleep(t)
    }
  }
}
