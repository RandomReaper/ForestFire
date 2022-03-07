package org.pignat.forestfire

object Main {
  def main(args: Array[String]): Unit = {
    val lib = new MyLibrary
    println(lib.sq(2))
    val w = new JvmDrawable
    w.test()
  }
}
