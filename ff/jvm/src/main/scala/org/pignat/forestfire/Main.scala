package org.pignat.forestfire

import java.awt.Color

object Main {
  def main(args: Array[String]): Unit = {
    val lib = new MyLibrary
    println(lib.sq(2))
    val w = new JvmDrawable
    for ( x <- 0 until w.getWidth()/2 ; y <- 0 until w.getHeight()/2 ) {
      w.setPixel(x,y, Color.black)
    }
    0 to w.getHeight()

    println(s"Using a JVM version ${System.getProperty("java.vm.version")}")
  }
}
