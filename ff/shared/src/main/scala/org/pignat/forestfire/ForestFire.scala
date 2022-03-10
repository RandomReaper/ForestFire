package org.pignat.forestfire
import scala.util.Random
import scala.math.min

class ForestFire(drawable: Drawable) {
  drawable.drawFilledRect(0, 0, drawable.width(), drawable.height(), new Color(0, 0, 0))

  val sz = 2

  val burnTime = 25
  val random = new Random()

  val chanceTreePercent = 0.01
  val chanceFirePercent = 0.0001

  var mem = Array.ofDim[Int](drawable.width() / (sz + 1), drawable.height() / (sz + 1))
  var trees = 0.0
  var fires = 0.0

  def resize(): Unit = {
    if (drawable.width() / (sz + 1) == mem.length && drawable.height() / (sz + 1) == mem(0).length) {
      return
    }

    val out = Array.ofDim[Int](drawable.width() / (sz + 1), drawable.height() / (sz + 1))

    for (x <- 0 until min(mem.length, out.length); y <- 0 until min(mem(0).length, out(0).length)) {
      out(x)(y) = mem(x)(y)
    }

    mem = out
  }

  def draw(): Unit = {
    drawable.startDrawing()
    drawable.drawFilledRect(0, 0, drawable.width(), drawable.height(), new Color(0, 0, 0))
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
    drawable.stopDrawing()
  }

  def step(i: Long): Unit = {
    resize()
    if (mem.length == 0 || mem(0).length == 0) {
      return
    }
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

    for (x <- mem.indices; y <- mem(0).indices) {
      mem(x)(y) match {
        case 0 | `burnTime` =>
        case v: Int => mem(x)(y) = v - 1
      }
    }

    var out = Array.ofDim[Int](drawable.width() / (sz + 1), drawable.height() / (sz + 1))
    for (x <- 0 until min(mem.length, out.length); y <- 0 until min(mem(0).length, out(0).length)) {
      out(x)(y) = mem(x)(y)
    }

    for (x <- mem.indices; y <- mem(0).indices; a <- -1 to 1; b <- -1 to 1) {
      if (x + a < 0 || x + a >= mem.length || y + b < 0 || y + b >= mem(0).length || (a==0 && b==0)) {

      } else {
        if (mem(x)(y) == burnTime) {
          if (mem(x + a)(y + b) > 0 && mem(x + a)(y + b) < burnTime) {
            out(x)(y) = burnTime - 1
          }
        }
      }
    }

    mem = out
    draw()
  }
}
