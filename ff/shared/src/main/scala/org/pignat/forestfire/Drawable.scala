package org.pignat.forestfire

trait Drawable {
  def getHeight() : Int
  def getWidth() : Int

  def setPixel(x:Integer, y:Integer, c:java.awt.Color)
}
