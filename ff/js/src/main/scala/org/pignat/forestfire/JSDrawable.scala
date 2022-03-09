package org.pignat.forestfire

import org.scalajs.dom
import org.scalajs.dom.{document, html}

class JSDrawable(id: String) extends Drawable {

  val c = document.getElementById(id).asInstanceOf[html.Canvas]
  val ctx = c.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  override def height(): Int = c.height

  override def width(): Int = c.width

  override def setPixel(x: Integer, y: Integer, c: Color): Unit = {
    ctx.fillStyle = f"rgba(${c.r},${c.g},${c.b},${c.a})"
    ctx.fillRect(x.toDouble, y.toDouble, 1, 1)
  }

  override def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer, c: Color): Unit = {
    ctx.fillStyle = f"rgba(${c.r},${c.g},${c.b},${c.a/255.0})"
    ctx.fillRect(x.toDouble, y.toDouble, w.toDouble, h.toDouble)
  }
}
