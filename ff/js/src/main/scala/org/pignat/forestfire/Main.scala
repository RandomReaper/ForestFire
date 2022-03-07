package org.pignat.forestfire

import org.scalajs.dom
import org.scalajs.dom.document

object Main {

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def appendCanvas(targetNode: dom.Node, id:String, width:Int, height:Int): Unit = {
    val n = document.createElement("canvas")
    n.id = id
    n.setAttribute("width", width.toString)
    n.setAttribute("height", height.toString)
    targetNode.appendChild(n)
  }

  def main(args: Array[String]): Unit = {
    val lib = new MyLibrary
    println(lib.sq(2))
    appendPar(document.body, "Hello World")
    appendCanvas(document.body, "cvs", 320, 240)
    val c = new JSDrawable("cvs")
    c.test()
  }
}
