# Currying
`def sum(f: Int => Int)(a: Int, b: Int): Int = ...`

The above definition receives a function (that takes an Int and returns
another Int) and returns another function (that takes two Int and
returns an Int). So the type of function `sum` is 

`(Int => Int) => ((Int, Int) => Int)`

Functional types associate to the right, which means `Int => Int => Int`
is equivalent to `Int => (Int => Int)`. As such we could have writen the
type of `sum` as `(Int => Int) => (Int, Int) => Int`. **This is
currying**.