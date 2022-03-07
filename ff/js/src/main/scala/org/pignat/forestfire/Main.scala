package org.pignat.forestfire

import org.scalajs.dom
import org.scalajs.dom.document

object Main {

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def main(args: Array[String]): Unit = {
    val lib = new MyLibrary
    println(lib.sq(2))
    appendPar(document.body, "Hello World")
    println(s"Using Scala.js version ${System.getProperty("java.vm.version")}")
  }
}
