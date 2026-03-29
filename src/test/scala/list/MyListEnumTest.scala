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

  test("append should join two lists correctly") {
    val list1 = 1 :: 2 :: Empty
    val list2 = 3 :: 4 :: Empty
    val result = list1.append(list2)

    assert(result.length == 4)
    // Verifying structure: 1 -> 2 -> 3 -> 4
    val expected = NonEmpty(1, NonEmpty(2, NonEmpty(3, NonEmpty(4, Empty))))
    assert(result == expected)
  }

  test("appending to Empty should return the other list") {
    val list = 1 :: 2 :: Empty
    assert(Empty.append(list) == list)
  }
  
}
