package org.pignat.playgrounds

import org.pignat.utils.{Color, Drawable, PlayGround}

import scala.math.min
import scala.util.Random

class Mondrian() extends PlayGround {
  var drawable: Drawable = null

  def init(d: Drawable): Unit = {
    drawable = d
    drawable.startDrawing()
    drawable.setColor(new Color(0, 0, 0))
    drawable.drawFilledRect(0, 0, drawable.width(), drawable.height())
    drawable.stopDrawing()
    resize()
  }

  val sz = 5
  val spc = 5

  val random = new Random(1)

  var mem = Array.ofDim[Int](0, 0)

  def resize(): Unit = {
    if (drawable.width() / (sz + spc) == mem.length && drawable.height() / (sz + spc) == mem(0).length) {
      return
    }

    val out = Array.ofDim[Int](drawable.width() / (sz + spc), drawable.height() / (sz + spc))

    for (x <- 0 until min(mem.length, out.length); y <- 0 until min(mem(0).length, out(0).length)) {
      out(x)(y) = mem(x)(y)
    }

    mem = out
  }

  def draw(): Unit = {
    val x = (0 +: (0 to 2 + random.nextInt(5)).map(x => random.nextInt(mem.length)) :+ (mem.length - 1)).map(_ * (sz + spc))
    val y = (0 +: (0 to 2 + random.nextInt(5)).map(x => random.nextInt(mem(0).length)) :+ (mem(0).length - 1)).map(_ * (sz + spc))
    drawable.startDrawing()
    drawable.setColor(new Color(0, 0, 0))
    drawable.drawFilledRect(0, 0, drawable.width(), drawable.height())
    drawable.setColor(new Color(255, 255, 255))
    for (a <- x.init.zip(x.tail); b <- y.init.zip(y.tail)) {
      val r = random.nextInt(255)
      drawable.setColor(new Color(r, r, r))
      drawable.drawFilledRectXY(a._1, b._1, a._2, b._2)
    }

    //x.foreach(a => drawable.drawFilledRect(a*(spc+sz), 0, sz, drawable.height()))
    //y.foreach(a => drawable.drawFilledRect(0, a*(spc+sz), drawable.width(), sz))
    drawable.stopDrawing()
  }

  def step(i: Long): Unit = {
    resize()

    if (mem.length == 0 || mem(0).length == 0) {
      return
    }

    draw()
  }
}
