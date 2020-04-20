package snake

import org.junit.runner.RunWith
import snake.SnakeRecord._
import snake.SnakeTests._
import org.scalatestplus.junit.JUnitRunner

abstract class SnakeTestSuite extends TestSuite {

  val mainTestList: List[Test] = List(
    testStartCorrectly,
    testApplePos3,
    testApplePos8,
    testNoRoomForApple,
    testMove,
    testIgnoreEatHead,
    testIgnoreEatHeadQuickSwitch,
    testIgnoreEatHeadQuickSwitch2,
    testChangeDirs,
    testWrapAroundEast,
    testWrapAroundWest,
    testWrapAroundNorth,
    testWrapAroundSouth,
    testGrow,
    testGrowTwice,
    testPreciselyDoesNotDie,
    testGameOver,
    testNoEscapeGameOver,
    testGame3x1,
    testGame6x6,
    testGame6x3,
    testGame10x7,
  )

  val mainInterTestList: List[InterleaveTest] = List(
    InterleaveTest("testInterleave6x3and10x7", testGame6x3, testGame10x7),
    InterleaveTest("testInterleave6x6and10x7", testGame6x6, testGame10x7),
  )



}

@RunWith(classOf[JUnitRunner])
class SnakeTestsAssignment1_1 extends SnakeTestSuite {

  val testList: List[Test] = mainTestList :+ testNoReverseMode
  reportOnUniformlyScoredTests(testList, mainInterTestList)
}

@RunWith(classOf[JUnitRunner])
class SnakeTestsAssignment1_3 extends SnakeTestSuite {
  val reverseTests: List[Test] = List(
    testReverseSimple,
    testReversePastStart,
    testReverseGameOver,
    testChangeThePast,
    testReverseLong,
  )

  val testList: List[Test] = mainTestList ++ reverseTests

  reportOnUniformlyScoredTests(testList, mainInterTestList)
}