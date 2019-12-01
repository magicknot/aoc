package duarte.industries.aoc
import scala.io.Source

object Puzzles extends App {
  println("Solving puzzle for Day 01")

  val (firstPart, secondPart) = Day01.solve(Utils.readInput("day01.txt"))
  println(s"1st Part: ${firstPart}")
  println(s"2nd Part: ${secondPart}")
}

object Utils {
  def readInput(resource: String): Seq[String] = {
    Source.fromResource(resource).getLines.toSeq
  }

}
