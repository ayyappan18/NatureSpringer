package com.springer.nature.drawing

/**
  * Created by ayyappan on 19/09/16.
  */
trait Shape

case class CanvasSize(w: Int, h: Int) extends Shape

case class Line(x1: Int, y1: Int, x2: Int, y2: Int) extends Shape

case class Rectangle(x1: Int, y1: Int, x2: Int, y2: Int) extends Shape