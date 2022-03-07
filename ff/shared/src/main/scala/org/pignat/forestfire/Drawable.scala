package org.pignat.forestfire

trait Drawable {
  def height() : Int
  def width() : Int

  def setPixel(x: Integer, y: Integer, r: Int, g: Int, b: Int): Unit

  def test() = {
    for ( x <- 0 until width()/2 ; y <- 0 until height()/2 ) {
      setPixel(x,y, 0, 0 ,0)
    }
    for ( x <- width()/2 until width() ; y <- 0 until height()/2 ) {
      setPixel(x,y, 255, 0 ,0)
    }
    for ( x <- 0 until width()/2 ; y <- height()/2 until height()) {
      setPixel(x,y, 0, 255 ,0)
    }
    for ( x <- width()/2 until width() ; y <- height()/2 until height()) {
      setPixel(x,y, 0, 0 ,255)
    }

  }
}
