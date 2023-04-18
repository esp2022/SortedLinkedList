# SortedLinkedList
Compilers:
javac LinkedListDriver.java
javac ItemType.java
javac NodeType.java
javac SortedLinkedList.java

Run:
java LinkedListDriver input.txt

Eeshwar Potluri esp94422@uga.edu
Responsible for ItemType.java
Responsible for search, delete, insert, getLength


Rohan Kothari rk56153@uga.edu
Responsible for NodeType.java 
Responsible for intersection, merge, delete alternate, get insertItem, reset 

Both responsible for driver.

Pseudocode for merge:

Set next node to null then return current node  
Set current node to null then return next node
Compare next to current and if less than 0 return next then current
Else set next to current then display 
The mergeSort method after will get the merged node in sorted order, then return the new list

Pseudocode for intersection:
When head2 is not equal to null set Nodetype temp to head1
When temp is not equal to null if temp value = head2 value return head2
Move temp to the next node and head2 to the next value

Time Complexities:

Merged Lists:
O(1)

Intersection:
O(n^2) 
