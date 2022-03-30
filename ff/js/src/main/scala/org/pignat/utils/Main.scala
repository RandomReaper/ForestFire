package org.pignat.utils

import org.pignat.playgrounds.ForestFire
import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.timers.setInterval

object Main {

  def appendCanvas(targetNode: dom.Node, id: String, width: Int, height: Int): Unit = {
    val n = document.createElement("canvas")
    n.id = id
    n.setAttribute("width", width.toString)
    n.setAttribute("height", height.toString)
    targetNode.appendChild(n)
  }

  def main(args: Array[String]): Unit = {
    appendCanvas(document.body, "cvs", 640, 480)
    val f = Selector.select("ForestFire", new JSDrawable("cvs", true))

    setInterval(100) {
      f.step(System.currentTimeMillis() / 100)
    }
  }
}
