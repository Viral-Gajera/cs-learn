# Definitions

| Approach            | Description                                                  |
| ------------------- | ------------------------------------------------------------ |
| Brute Force         | Tries all possibilities.                                     |
| Recursion           | Function calling is self.                                    |
| Backtracking        | We start with one possible option out of manay available options and cheack if it gives solution, otherwise we backtrack/undo/retrace and select some other option and try to solve problem. (Uses DFS) |
| Branch &  <br>Bound | (Similar to Backtracking) Uses BFS to explore the options, and eliminate certain paths using bounding techniques. (Can use BFS or DFS) |
| Greedy Approach     | Makes locally optimal choices at each stage without bothering about other stage. |
| Divide & Conquer    | Breaks a problem into smaller sub problems, solves them independently, and then combines their solutions. |
| Dynamic Programming | Stores the result of subproblem, for the future usage. (Overlaping Subproblem, Optimal sub structure) |


# Problems

Recursion & Backtracking:
```
Tower of hanoi
Generate all binary & n-ary strings

N Queens problem
```

Greedy Method:
```
Selection sort, Topological sort, Heap sort
Huffman coding compression

Prim's & Kruskal's algorithms
Dijkstra's algorithms

Fractional knapsack problem

Activity selection problem
Job scheduling algorithms
```

Divide & Conquer:
```
Binary search
Merge sort & Quick sort

Strassen's matrix multiplication
```

Dynamic Programming:
```
Longest common subsequence & substring
Longest palindrome subsequence & substring
Longest increasing subsequence

Bellman-ford algorithm
floyd warshall algorithm

Chain matrix multiplication

0/1 knapsack
Coin change problem 
```