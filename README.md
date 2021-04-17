# nokia-snake-game

### WHY ArrayDeque, not LinkedList???

"*null* elements are allowed in the LinkedList implementation but not in the ArrayDeque implementation.<br>
In terms of efficiency, ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends. The best operation in a LinkedList implementation is removing the current element during the iteration. LinkedList implementations are not ideal structures to iterate.

The LinkedList implementation consumes more memory than the ArrayDeque implementation." - As specified in the ultimate [source](https://docs.oracle.com/javase/tutorial/collections/implementations/deque.html) of truth.

---
***So if you don't have to support NULL elements && looking for less memory && efficiency of add/remove elements at both ends, ArrayDeque is the best choice!!!***
