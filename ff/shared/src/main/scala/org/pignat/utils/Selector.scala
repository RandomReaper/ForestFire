package org.pignat.utils

import org.pignat.playgrounds.ForestFire
import org.pignat.playgrounds.Mondrian

import scala.collection.immutable.HashMap

object Selector {
  private val playgrounds = HashMap(
    "forestfire" -> new ForestFire(),
    "mondrian" -> new Mondrian()
  )

  def usage(): String = {
    "possible experiment : " + playgrounds.keys.mkString(",")
  }

  def select(name: String = "", drawable: Drawable): PlayGround = {
    val f = playgrounds.getOrElse(name, new ForestFire())
    f.init(drawable)
    return f
  }
}
