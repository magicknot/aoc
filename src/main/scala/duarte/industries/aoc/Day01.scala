package duarte.industries.aoc
import scala.annotation.tailrec

object Day01 {
  def parse(input: Seq[String]): Seq[Int] = input.map(_.toIntOption).flatten
  def solve(input: Seq[String]): (Int, Int) = {
    val parsedInput = parse(input)

    (firstPart(parsedInput), secondPart(parsedInput))
  }

  def fuelForModule(mass: Int): Int = mass / 3 - 2

  def fuelForModuleAndItsFuel(mass: Int): Int = {
    @tailrec def fuel(total: Int, mass: Int): Int = {
      if (mass <= 0) total
      else {
        val currentFuel = Math.max(fuelForModule(mass), 0)
        fuel(total + currentFuel, currentFuel)
      }
    }

    fuel(0, mass)
  }

  def firstPart(modules: Seq[Int]): Int =
    modules.foldLeft(0)(_ + fuelForModule(_))
  def secondPart(modules: Seq[Int]): Int =
    modules.foldLeft(0)(_ + fuelForModuleAndItsFuel(_))
}
