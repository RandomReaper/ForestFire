package org.pignat.forestfire

import org.scalajs.dom
import org.scalajs.dom.{UIEvent, document, html}

class JSDrawable(id: String, fullScreen: Boolean) extends Drawable {

  val canvas: html.Canvas = document.getElementById(id).asInstanceOf[html.Canvas]
  var canvasBuffer: html.Canvas = document.createElement("canvas").asInstanceOf[html.Canvas]

  def buffer(): dom.CanvasRenderingContext2D = {
    canvasBuffer = document.createElement("canvas").asInstanceOf[html.Canvas]
    canvasBuffer.width = canvas.width
    canvasBuffer.height = canvas.height
    return canvasBuffer.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  }

  var buf = buffer()

  def resize(): Unit = {
    canvas.width = dom.window.innerWidth.toInt
    canvas.height = dom.window.innerHeight.toInt

    buf = buffer()
  }

  if (fullScreen) {
    dom.window.onresize = { (e: UIEvent) =>
      resize()
    }
    resize()
  }

  //private def color(c: Color): String = f"rgba(${c.r},${c.g},${c.b},${c.a / 255.0})"
  private def color(c: Color): String = "rgba(" + c.r + "," + c.g + "," + c.b + "," + c.a / 255.0

  override def height(): Int = canvas.height

  override def width(): Int = canvas.width

  override def setColor(c: Color): Unit = {
    buf.fillStyle = color(c)
  }

  override def setPixel(x: Integer, y: Integer): Unit = {
    buf.fillRect(x.toDouble, y.toDouble, 1, 1)
  }

  override def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer): Unit = {
    buf.fillRect(x.toDouble, y.toDouble, w.toDouble, h.toDouble)
  }

  override def stopDrawing(): Unit = {
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.drawImage(canvasBuffer, 0, 0)
    super.stopDrawing()
  }
}
