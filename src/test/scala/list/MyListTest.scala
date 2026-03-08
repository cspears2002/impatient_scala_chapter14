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

    myListA == List(0, 1, 2, 3)
  }
  test("Prepend a another MyList to a MyList") {
    val myList = MyList(List(1, 2, 3))
    val myList1 = MyList(List(-1, 0))
    val myListB = myList1 :: myList
    
    myListB == List(-1, 0, 1, 2, 3)
  }
}
