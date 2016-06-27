The `union` method from the lectures does not work well when submitting
because it takes a long time and probably consumes more memory.

`def union(that: TweetSet): TweetSet =
    ((left union right) union that) incl elem`

A better union is the following:

`(right union (left union that)) incl elem`

The reasons for this are better explained by these two comments on the
course forums [link](https://www.coursera.org/learn/progfun1/programming/Ogg05/object-oriented-sets/discussions/threads/AzJ-4CLYEeag6wpD-92Rcw).
First comment:

    I wrote out a couple toy examples of x.union(y) with the two definitions.
    The difference is striking.
    
    (left union (right union other)) incl elem ends up rewritten into 
    Empty union Empty union Empty ... union other incl elem0 
        incl elem1 ... incl elem n
        
    In other words, after all the rewrites, the evaluation is just n calls 
    to Empty.union() followed by n calls to NonEmpty.incl(elem), where n is
    the number of non-empty nodes in your set.
    
    On the other hand, ((left union right) union other) incl elem ends up 
    rewritten into something like 
    (Empty incl elem ) union (NonEmpty incl elem) union ... 
        union (other incl elem)
    So instead of n calls to Empty.union(Empty) or whatever, you get 
    exponentially (!!!) more calls to NonEmpty.union(NonEmpty).


Second comment:

    Let's define the size of this and that as n. As usual with big-O 
    notation, we assume approximately the same size here; we're only 
    interested how the order of magnitude changes with increasing set sizes.
    
    union1 recurses into right and left, each containing about n/2 elements.
    For each element we call incl, which effectively does an insert sort in 
    a binary tree (this is O(log(n))). Combined, the complexity is O(n * log(n)).
    
    union2 recurses into right and right.union(that), thus the complexity
    for the recursion is O(n/2) + O(n/2 * n) = O(n) + O(n^2) = O(n^2). As 
    all implementations call incl, the combined complexity is O(n^2 * log(n)^2).
    
    union3 recurses identically to union1, for complexity O(n * log(n)).
    However, we get some improvement due to tail recursion. This is due to
    mechanical sympathy (we use less stack space, causing less CPU cache
    invalidation) but does not reduce the big-O complexity
