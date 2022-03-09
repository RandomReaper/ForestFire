package org.pignat.forestfire

import org.pignat.forestfire

import java.awt.{BorderLayout, Canvas, Color, Dimension, Graphics, Label}
import javax.swing.{JFrame, WindowConstants}
import java.awt.image.BufferedImage


class JvmDrawable extends Drawable {

  val frame = new JFrame("FrameDemo")
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  val bufferedImage = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB)
  val canvas = new Canvas {
    protected override def paint(g: Graphics): Unit = {
      super.paint(g)
      g.drawImage(bufferedImage, 0, 0, null)
    }
  }

  canvas.setSize(320, 240)
  canvas.setVisible(true)
  frame.getContentPane.add(canvas, BorderLayout.CENTER)
  frame.pack
  frame.setVisible(true)

  override def height(): Int = frame.getHeight

  override def width(): Int = frame.getWidth

  override def setPixel(x: Integer, y: Integer, c: org.pignat.forestfire.Color): Unit = {
    val g = bufferedImage.getGraphics()
    g.setColor(new java.awt.Color(c.r, c.g, c.b, c.a))
    g.drawLine(x, y, x + 1, y + 1)
    frame.repaint()
  }

  override def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer, c: forestfire.Color): Unit = {
    val g = bufferedImage.getGraphics()
    g.setColor(new java.awt.Color(c.r, c.g, c.b, c.a))
    g.fillRect(x, y, w, h)
  }
}
