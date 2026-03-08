package list

import org.scalactic.Prettifier.default
import org.scalatest.funsuite.AnyFunSuite

class MyListTest extends AnyFunSuite {
  test("MyList with empty list is Empty") {
    val myList = MyList(List())
    myList.isEmpty
  }
  test("MyList with a non-empty list is nonEmpty") {
    val myList = MyList(List(1, 2, 3))
    myList.nonEmpty
  }
  test("Empty MyList returns a head of None") {
    val myList = MyList(List())
    myList.head.isEmpty
  }
  test("Non-empty MyList returns a head of Some(element)") {
    val myList = MyList(List(1, 2, 3))
    myList.head.contains(1)
  }
  test("Empty MyList returns a tail of None") {
    val myList = MyList(List())
    myList.tail.isEmpty
  }
  test("Non-empty MyList returns a tail of that is a list") {
    val myList = MyList(List(1, 2, 3))
    myList.tail.contains(List(2, 3))
  }
  test("Prepend a single element to a MyList") {
    val myList = MyList(List(1, 2, 3))
    val myListA = 0 :: myList
    myListA == MyList(List(0, 1, 2, 3))
  }
  test("Prepend another MyList to a MyList") {
    val myList = MyList(List(1, 2, 3))
    val myList1 = MyList(List(-1, 0))
    val myListB = myList1 :: myList
    myListB == MyList(List(-1, 0, 1, 2, 3))
  }
  test("Length returns number of items in a MyList") {
    val myList = MyList(List(1, 2, 3))
    myList.length == 3
  }
  test("Append a single element to a MyList") {
    val myList = MyList(List(1, 2, 3))
    val myListA = myList :+ 4
    myListA == MyList(List(1, 2, 3, 4))
  }
  test("Append another MyList to a MyList") {
    val myList1 = MyList(List(1, 2))
    val myList2 = MyList(List(3, 4))
    val combinedMyList = myList1 ++ myList2
    combinedMyList == MyList(List(1, 2, 3, 4))
  }
}
