package org.pignat.utils

import org.pignat.playgrounds.ForestFire
import org.pignat.playgrounds.Mondrian

object Selector {
  def select(name:String, drawable: Drawable): PlayGround = {
    val f = new Mondrian()
    f.init(drawable)
    return f
  }
}
