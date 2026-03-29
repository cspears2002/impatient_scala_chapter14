package list

import list.MyListEnum.*

import org.scalatest.funsuite.AnyFunSuite


class MyListEnumTest extends AnyFunSuite {
  test("length of Empty should be 0") {
    val list = Empty
    assert(list.length == 0)
  }

  test("length of a single element list should be 1") {
    val list = "First" :: Empty
    assert(list.length == 1)
  }

  test("length of a multi-element list should be correct") {
    // Building a list: 10 -> 20 -> 30
    val list = 10 :: 20 :: 30 :: Empty
    assert(list.length == 3)
  }

  test("length should handle mixed types via covariance") {
    val list = 1 :: "Two" :: 3.0 :: Empty
    assert(list.length == 3)
  }
  
}
