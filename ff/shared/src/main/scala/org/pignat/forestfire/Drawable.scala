package org.pignat.forestfire

trait Drawable {
  def height(): Int

  def width(): Int

  def setColor(c: Color): Unit

  def setPixel(x: Integer, y: Integer): Unit

  def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer)

  def startDrawing() = {}

  def stopDrawing() = {}

  def test() = {
    startDrawing()
    for (x <- 0 until width() / 2; y <- 0 until height() / 2) {
      setColor(new Color(0, 0, 0))
      setPixel(x, y)
    }
    for (x <- width() / 2 until width(); y <- 0 until height() / 2) {
      setColor(new Color(255, 0, 0))
      setPixel(x, y)
    }
    for (x <- 0 until width() / 2; y <- height() / 2 until height()) {
      setColor(new Color(0, 255, 0))
      setPixel(x, y)
    }
    for (x <- width() / 2 until width(); y <- height() / 2 until height()) {
      setColor(new Color(0, 0, 255))
      setPixel(x, y)
    }

    setColor(new Color(255, 255, 255))
    drawFilledRect(10, 10, 10, 10)
    setColor(new Color(255, 255, 255, 127))
    drawFilledRect(20, 20, 10, 10)

    stopDrawing()
  }
}
