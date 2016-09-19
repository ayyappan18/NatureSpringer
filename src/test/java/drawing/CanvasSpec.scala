package drawing

import com.springer.nature.drawing.{Canvas, CanvasSize, Line, PointOutsideCanvasException}
import org.scalatest.FunSpec

/**
  * Created by ayyappan on 19/09/16.
  */
class CanvasSpec extends FunSpec {

  describe("A canvas") {
    describe("when initialised") {
      it("should be empty") {
        val canvas = new Canvas(CanvasSize(4,4))
        assert(canvas.canvas.forall(_.forall(_ == ' ')))
      }
    }
  }
  describe("draw line") {
    it("should draw a horizontal line") {
      val canvas = new Canvas(CanvasSize(10,4))
      canvas.drawLine(Line(1,1,3,1))
      assert(canvas.canvas(0).slice(0,2).forall(_ == 'X'))
    }
    it("should draw a vertical line") {
      val canvas = new Canvas(CanvasSize(10,4))
      canvas.drawLine(Line(1,1,1,3))
      for(i <- 0 to 2){
        assert(canvas.canvas(i)(0) == 'X')
      }
    }
    it("throw PointOutsideCanvasException if point is outside canvas") {
      assertThrows[PointOutsideCanvasException]{
        val canvas = new Canvas(CanvasSize(10,4))
        canvas.drawLine(Line(1,1,1,5))
      }
    }
  }
}
