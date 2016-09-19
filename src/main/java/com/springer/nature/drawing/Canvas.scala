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
    if(line.x1 > canvasSize.w || line.x2 > canvasSize.w || line.y1 > canvasSize.h || line.y2 > canvasSize.h)
      throw new PointOutsideCanvasException()
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
    if(rectangle.x1 > canvasSize.w || rectangle.x2 > canvasSize.w || rectangle.y1 > canvasSize.h || rectangle.y2 > canvasSize.h)
      throw new PointOutsideCanvasException()
    val lines = List(
      Line(rectangle.x1, rectangle.y1, rectangle.x2, rectangle.y1),
      Line(rectangle.x1, rectangle.y1, rectangle.x1, rectangle.y2),
      Line(rectangle.x2, rectangle.y1, rectangle.x2, rectangle.y2),
      Line(rectangle.x1, rectangle.y2, rectangle.x2, rectangle.y2)
    )
    lines.foldLeft(canvas)((canvas, line) => drawLine(line))
  }

  def bucketFill(point: Point, filling: Char): CanvasBoard = {
    for(w <- 0 to canvasSize.w){
      for(h <- point.y to canvasSize.h){

        canvas(h)
      }
    }
    canvas(point.x)
    val closestLine = canvas(point.x).indexWhere(_ == 'X')
    for(i <- point.x-1 to closestLine-1) canvas(point.x).update(i,filling)
    canvas
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

