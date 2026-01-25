package items

import org.scalatest.funsuite.AnyFunSuite

class MultipleTest extends AnyFunSuite{
  test("The price of a Multiple with a SimpleItem") {
    val toaster = SimpleItem(29.95, "Blackwell Toaster")
    val manyToasters = Multiple(10, toaster)
    assert(manyToasters.price == 29.95 * 10)
  }
  test("The price of a Multiple with a Bundle") {
    val blackWell = SimpleItem(29.95, "Blackwell Toaster")
    val whiteWell = SimpleItem(35, "Whitewell Toaster")
    val toasterBundle = Bundle("Two types of toasters")
    toasterBundle.itemsArrayBuff.addOne(blackWell)
    toasterBundle.itemsArrayBuff.addOne(whiteWell)
    assert(toasterBundle.price == blackWell.price + whiteWell.price)
  }
}
