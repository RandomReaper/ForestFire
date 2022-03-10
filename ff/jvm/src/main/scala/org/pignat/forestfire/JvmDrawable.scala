package org.pignat.forestfire

import org.pignat.forestfire

import java.awt.{BorderLayout, Canvas, Color, Dimension, Graphics, Label}
import javax.swing.{JFrame, WindowConstants, JPanel}
import java.awt.image.BufferedImage

class JvmDrawable extends Drawable {

  val frame = new JFrame("ForestFire")
  frame.getContentPane()
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  var bufferedImage = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB)
  val panel = new JPanel {
    protected override def paint(g: Graphics): Unit = {
      if (getSize().height != bufferedImage.getHeight() || getSize().width != bufferedImage.getWidth()) {
        bufferedImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB)
      }
      super.paint(g)
      g.drawImage(bufferedImage, 0, 0, null)
    }
  }
  val d = new Dimension(800, 600)
  panel.setSize(d)
  panel.setMinimumSize(d)
  panel.setPreferredSize(d)
  panel.setVisible(true)
  frame.getContentPane.add(panel, BorderLayout.CENTER)
  frame.pack
  frame.setVisible(true)

  override def height(): Int = frame.getHeight

  override def width(): Int = frame.getWidth

  override def setPixel(x: Integer, y: Integer, c: org.pignat.forestfire.Color): Unit = {
    val g = bufferedImage.getGraphics()
    g.setColor(new java.awt.Color(c.r, c.g, c.b, c.a))
    g.drawLine(x, y, x + 1, y + 1)
  }

  override def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer, c: forestfire.Color): Unit = {
    val g = bufferedImage.getGraphics()
    g.setColor(new java.awt.Color(c.r, c.g, c.b, c.a))
    g.fillRect(x, y, w, h)
  }

  override def stopDrawing(): Unit = {
    panel.repaint()
    super.stopDrawing()
  }
}
