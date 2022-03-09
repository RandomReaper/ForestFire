package org.pignat.forestfire
import scala.util.Random

class ForestFire(drawable: Drawable) {
  drawable.drawFilledRect(0, 0, drawable.width(), drawable.height(), new Color(0, 0, 0))

  val sz = 5

  val burnTime = 25
  val random = new Random()

  val chanceTreePercent = 0.01
  val chanceFirePercent = 0.0001

  var mem = Array.ofDim[Int](drawable.width() / (sz + 1), drawable.height() / (sz + 1))
  var trees = 0.0
  var fires = 0.0

  def step(i: Long): Unit = {
    val tot = drawable.width() * drawable.height()

    trees += random.nextDouble() * tot * chanceTreePercent / 100.0
    fires += random.nextDouble() * tot * chanceFirePercent / 100.0

    for (i <- 0 until trees.toInt) {
      val x = random.nextInt(mem.length)
      val y = random.nextInt(mem(0).length)

      if (mem(x)(y) == 0) {
        mem(x)(y) = burnTime
      }
    }
    trees -= trees.toInt

    for (i <- 0 until fires.toInt) {
      val x = random.nextInt(mem.length)
      val y = random.nextInt(mem(0).length)
      if (mem(x)(y) == burnTime) {
        mem(x)(y) = burnTime - 1
      }
    }
    fires -= fires.toInt

    val c0 = new Color(0, 0, 0)
    val c1 = new Color(0, 255, 0)
    val c2 = new Color(255, 0, 0)
    for (x <- mem.indices; y <- mem(0).indices) {
      mem(x)(y) match {
        case 0 => drawable.drawFilledRect((sz + 1) * x, (sz + 1) * y, sz, sz, c0)
        case `burnTime` => drawable.drawFilledRect((sz + 1) * x, (sz + 1) * y, sz, sz, c1)
        case v: Int => drawable.drawFilledRect((sz + 1) * x, (sz + 1) * y, sz, sz, new Color(v * 255 / burnTime, 0, 0));
      }
    }
    for (x <- mem.indices; y <- mem(0).indices) {
      mem(x)(y) match {
        case 0 | `burnTime` =>
        case v: Int => mem(x)(y) = v - 1
      }
    }

    val out = mem.map(identity)

    for (x <- mem.indices; y <- mem(0).indices; a <- -1 to 1; b <- -1 to 1) {
      if (x + a < 0 || x + a >= mem.length || y + b < 0 || y + b >= mem(0).length) {

      } else {
        if (mem(x)(y) == burnTime) {
          if ((a != 0 || b != 0) && mem(x + a)(y + b) > 0 && mem(x + a)(y + b) < burnTime) {
            out(x)(y) = burnTime - 1
          }
        }
      }
    }

    mem = out
  }

}