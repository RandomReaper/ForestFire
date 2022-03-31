package org.pignat.utils

import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js
import scala.scalajs.js.timers.setInterval

object Main {

  def appendCanvas(targetNode: dom.Node, id: String, width: Int, height: Int): Unit = {
    val n = document.createElement("canvas")
    n.id = id
    n.setAttribute("width", width.toString)
    n.setAttribute("height", height.toString)
    targetNode.appendChild(n)
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def parameters(): Map[String, String] = {
    val s = dom.window.location.search
    if (s == "" || s(0) != '?') {
      return Map[String, String]()
    }
    return s.tail.split('#')(0).split("&").map(js.URIUtils.decodeURIComponent).map(x => {
      val a = x.split("=")
      if (a.length > 1) {
        (a(0), a(1))
      } else {
        (a(0), "")
      }
    }).toMap
  }

  def main(args: Array[String]): Unit = {
    val p = parameters()
    val h = p.contains("help")

    if (h) {
      appendPar(document.body, "use '?what=experiment', " + Selector.usage())
      return
    }

    appendCanvas(document.body, "cvs", 640, 480)
    val n = p getOrElse("what", "")
    val f = Selector.select(n, new JSDrawable("cvs", true))

    setInterval(100) {
      f.step(System.currentTimeMillis() / 100)
    }
  }
}
