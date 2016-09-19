package com.springer.nature.drawing

import scala.io.StdIn

/**
  * Created by ayyappan on 19/09/16.
  */
object DrawingBoard extends App{

  trait Shape
  var exit = false
  var canvas: Canvas = null

  while (!exit) {
    println("1. create a new canvas.")
    println("2. start drawing on the canvas by issuing various commands.")
    println("3. quit")

    val input = StdIn.readInt()
    input match {
      case 1 => {
        print("enter a command: ")
        val cs = StdIn.readLine()
        if (cs.startsWith("C")) {
          val size = cs.split(" ")
          val canvasSize = CanvasSize(size(1).toInt, size(2).toInt)
          canvas = new Canvas(canvasSize)
          canvas.printCanvas()
        } else {
          println("enter a valid canvas commmand")
        }
      }
      case 2 => {
        print("enter a command: ")
        val command = StdIn.readLine() split (" ")
        command(0) match {
          case "L" => {
            val line = Line(command(1).toInt, command(2).toInt, command(3).toInt, command(4).toInt)
            canvas.drawLine(line)
            canvas.printCanvas()
          }
          case "R" => {
            val rectangle = Rectangle(command(1).toInt, command(2).toInt, command(3).toInt, command(4).toInt)
            canvas.drawRectangle(rectangle)
            canvas.printCanvas()
          }
          case "Q" => exit = true
          case _ => println("Invalid Command")
        }
      }
      case 3 => exit = true
      case _ => println("Invalid Command")
    }
  }
}
