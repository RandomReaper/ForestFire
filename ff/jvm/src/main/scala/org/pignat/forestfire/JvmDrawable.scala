package org.pignat.forestfire

import java.awt.{BorderLayout, Color, Dimension, Label}
import javax.swing.{JFrame, WindowConstants}
import java.awt.Canvas
import java.awt.image.BufferedImage
import java.awt.Color


class JvmDrawable extends Drawable{

  val frame = new JFrame("FrameDemo")
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  val c = new Canvas

  c.setSize(320, 240)
  c.setVisible(true)
  frame.getContentPane.add(c, BorderLayout.CENTER)
  frame.pack
  frame.setVisible(true)
  val b = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB)

  override def height(): Int = frame.getHeight

  override def width(): Int = frame.getWidth

  override def setPixel(x: Integer, y: Integer, r: Int, g: Int, b: Int): Unit = {
    val gr = c.getGraphics()
    gr.setColor(new Color(r,g,b))
    gr.drawLine(x, y, x+1, y+1)
  }
}
