package org.pignat.forestfire

class ForestFire(drawable: Drawable) {

  def step(i: Long): Unit = {
    val c1 = new Color(if (i % 2 == 0) 0 else 255, 0, 0)
    val c2 = new Color(0, if (i / 2 % 2 == 0) 0 else 255, 0)
    val c3 = new Color(0, 0, if (i / 4 % 2 == 0) 0 else 255)
    drawable.drawFilledRect(0, 0, 10, 10, c1)
    drawable.drawFilledRect(0, 10, 10, 10, c2)
    drawable.drawFilledRect(0, 20, 10, 10, c3)
  }
}
