import funsets.FunSets

FunSets.singletonSet(1)
val under2 : FunSets.Set = FunSets.singletonSet(1)
val under10 : FunSets.Set = (x :Int) => if (x < 10) true else false