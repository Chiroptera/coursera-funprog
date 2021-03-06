# Evaluation
## Call by Value and Call by Name
```scala
def countOne(x: Int, y: Int) = 1
def conntOne(x: Int, y: => Int) = 1
```

In the first definition both x and y are evaluated, since we're using call by value on both parameters. On the second definition only x is evaluated, since y will be called by name and y never appears in the function body.

## Call by Name vs. Call by Need (lazy evaluation)
```scala
def test(x: => Double) = 
  val y = x + 1
  true
```

In this function, call by name would evaluate x on the first line of the function body. If we were to use call by need, however, the evaluator would synthatically replace the y expression by a structure named _thunk_, which is basically a promise that we will compute `y = x + 1` in the future, if we need to. However, `y` is never used because the function simply returns `true`. As such, the expression in the thunk is never actually computed and `x` never gets evaluated. Call by need and call by name are both types of _non-strict evaluation_.
