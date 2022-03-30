package org.pignat.utils

import org.pignat.utils.Drawable

import java.awt.{BorderLayout, Canvas, Color, Dimension, Graphics, Label}
import javax.swing.{JFrame, JPanel, WindowConstants}
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

  var g: Graphics = null

  override def startDrawing(): Unit = {
    super.startDrawing()
    g = bufferedImage.getGraphics()
  }

  override def setColor(c: org.pignat.utils.Color): Unit = {
    g.setColor(new java.awt.Color(c.r, c.g, c.b, c.a))
  }

  override def setPixel(x: Integer, y: Integer): Unit = {
    g.drawLine(x, y, x + 1, y + 1)
  }

  override def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer): Unit = {
    g.fillRect(x, y, w, h)
  }

  override def stopDrawing(): Unit = {
    g = null
    panel.repaint()
    super.stopDrawing()
  }
}
