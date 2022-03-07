package org.pignat.forestfire
import org.scalajs.dom
import org.scalajs.dom.{document, html}
class JSDrawable(id:String) extends Drawable {

  val c = document.getElementById(id).asInstanceOf[html.Canvas]
  val ctx = c.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  override def height(): Int = c.height
  override def width(): Int = c.width

  override def setPixel(x: Integer, y: Integer, r: Int, g: Int, b: Int): Unit = {
    ctx.fillStyle = f"rgb($r,$g,$b)"
    ctx.fillRect(x.toDouble, y.toDouble , 1, 1)
  }
}
