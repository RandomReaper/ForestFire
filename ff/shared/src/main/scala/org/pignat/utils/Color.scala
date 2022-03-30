package org.pignat.utils

class Color(val r: Int, val g: Int, val b: Int, val a: Int) {
  def this(r: Int, g: Int, b: Int) = {
    this(r, g, b, 255)
  }
}
