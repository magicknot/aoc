package duarte.industries.aoc

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.prop.TableDrivenPropertyChecks

import Day01._

class Day01Test extends AnyFunSpec with TableDrivenPropertyChecks {

  describe("Calculating the fuel requirements") {
    it("considers just the mass") {
      val masses = Table(
        ("mass", "result"),
        (12, 2),
        (14, 2),
        (1969, 654),
        (100756, 33583)
      )

      forAll(masses) { (mass, result) =>
        assert(fuelForModule(mass) == result)
      }
    }

    it("considers the mass and its fuel") {
      val masses = Table(
        ("mass", "result"),
        (12, 2),
        (14, 2),
        (1969, 966),
        (100756, 50346)
      )

      forAll(masses) { (mass, result) =>
        assert(fuelForModuleAndItsFuel(mass) == result)
      }
    }
  }

  describe("solving the exercise") {
    it("calculates the required fuel for the first part") {
      val modulesWithResults = Table(
        ("module", "result"),
        (Seq(12), 2),
        (Seq(12, 14), 4),
        (Seq(12, 14, 1969), 658),
        (Seq(12, 14, 1969, 100756), 34241),
        (Seq.empty[Int], 0)
      )

      forAll(modulesWithResults) { (modules, result) =>
        assert(firstPart(modules) == result)
      }
    }

    it("calculates the required fuel for the second part") {
      val modulesWithResults = Table(
        ("module", "result"),
        (Seq(12), 2),
        (Seq(12, 14), 4),
        (Seq(12, 14, 1969), 970),
        (Seq(12, 14, 1969, 100756), 51316),
        (Seq.empty[Int], 0)
      )

      forAll(modulesWithResults) { (modules, result) =>
        assert(secondPart(modules) == result)
      }
    }

    it("parses the input") {
      val resources = Table(
        ("lines", "result"),
        (Seq("1"), Seq(1)),
        (Seq("1", "2"), Seq(1, 2)),
        (Seq("A"), Seq.empty[Int])
      )

      forAll((resources)) { (lines, result) =>
        assert(parse(lines) == result)
      }
    }
  }
}
