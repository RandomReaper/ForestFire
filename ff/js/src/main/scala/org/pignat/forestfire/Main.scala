package org.pignat.forestfire

import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.Date
import scala.scalajs.js.timers._

object Main {

  def appendCanvas(targetNode: dom.Node, id: String, width: Int, height: Int): Unit = {
    val n = document.createElement("canvas")
    n.id = id
    n.setAttribute("width", width.toString)
    n.setAttribute("height", height.toString)
    targetNode.appendChild(n)
  }

  def main(args: Array[String]): Unit = {
    appendCanvas(document.body, "cvs", 320, 240)
    val c = new JSDrawable("cvs")
    c.test()
    val f = new ForestFire(c)
    setInterval(100) {
      f.step(System.currentTimeMillis() / 100)
    }
  }
}
