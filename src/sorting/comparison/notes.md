# Comparison Based Sorting 

Comparison based sorting includes: 
- MergeSort
- QuickSort
- HeapSort

## General Info  
Take input array `a`  
Sort element of `a` in ascending order
Take input `c`, a `Comparator`  
  implements the `compare(a,b)` method
    return negative if `a < b`
    return positive if `a > b`
    return 0 if `a = b`

## Runtime
All run in `O(n log n)` time  
This is best possible run time for comparisons  

### Other comparisons?
SSet and PriorityQueue can also obtain this run time with an algorithm  
These require a lot of memory overhead due to add/remove ops