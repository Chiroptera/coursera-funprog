import week3._

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

def find[T](pos: Int, list: List[T]): T = {
  if (curr.isEmpty) throw IndexOutOfBoundsException
  if (pos == 0) curr.head
  else find(pos - 1, curr.tail)
}

singleton[Int](2)