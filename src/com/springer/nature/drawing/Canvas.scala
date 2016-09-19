package com.springer.nature.drawing

/**
  * Created by ayyappan on 19/09/16.
  */
class Canvas(canvasSize: CanvasSize) {
  type CanvasBoard = Array[Array[Char]]
  val canvas = Array.ofDim[Char](canvasSize.h, canvasSize.w)
  for (i <- 0 until canvasSize.h) {
    for (j <- 0 until canvasSize.w) {
      canvas(i).update(j, ' ')
    }
  }

  def drawLine(line: Line): CanvasBoard = {
    if(line.x1 == line.x2){
      for (i <- line.y1-1 to line.y2-1)
        canvas(i).update(line.x1-1, 'X')
    }
    if (line.y1 == line.y2){
      for (i <- line.x1-1 to line.x2-1)
        canvas(line.y1-1).update(i, 'X')
    }
    canvas
  }

  def drawRectangle(rectangle: Rectangle): CanvasBoard = {
    val lines = List(
      Line(rectangle.x1, rectangle.y1, rectangle.x2, rectangle.y1),
      Line(rectangle.x1, rectangle.y1, rectangle.x1, rectangle.y2),
      Line(rectangle.x2, rectangle.y1, rectangle.x2, rectangle.y2),
      Line(rectangle.x1, rectangle.y2, rectangle.x2, rectangle.y2)
    )
    lines.foldLeft(canvas)((canvas, line) => drawLine(line))
  }

  def printCanvas(): Unit = {
    for (i <- -1 to canvasSize.h) {
      print('|')
      for (j <- 0 until canvasSize.w) {
        if (i == -1 || i == canvasSize.h) print("—")
        else print(canvas(i)(j))
      }
      println('|')
    }
  }
}

