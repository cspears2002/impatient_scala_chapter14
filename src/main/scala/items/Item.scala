import scala.collection.mutable.ArrayBuffer

package items:

    abstract class Item:
        def price: Double
        def description: String

    class SimpleItem(myPrice: Double, myDesc: String) extends Item:
        def price: Double = myPrice
        def description: String = myDesc

    class Bundle(bundleDesc: String) extends Item:
        var itemsArrayBuff = ArrayBuffer[Item]()
        def price: Double =
            var sum = 0.0
            for (item <- itemsArrayBuff) {
                sum = sum + item.price
            }
            sum

        def description: String = bundleDesc


    case class Multiple(numItems: Int, myItem: Item) extends Item:
        override def description: String = myItem.description
        override def price: Double = myItem.price * numItems

