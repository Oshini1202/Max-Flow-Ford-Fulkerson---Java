# Max-Flow-Ford-Fulkerson---Java

## Chosen algorithms
This maximum possible flow implementation of Ford Fulkerson Algorithm is called Edmonds-Karp algorithm and part from that breadth-first search algorithm is additionally used in that. 
Flow network is a directed graph where each edge has a capacity and a flow. Ford-Fulkerson algorithm is a greedy algorithm and it uses to compute the maximum flow in a flow network.

The steps on that algorithm are mentioned below.
* Find a path from source(s) to sink(t)
* After solving this path, it finds another path by using available capacities on all the edges in that particular path and this process called augmented path. After that it will find another path and continues the process.

I used Breadth First Search (BFS) to find if there a path exists from source(s) to sink(t). The reason for selecting BFS was because it always picks up the path with the minimum number of edges and the worst case time complexity can be reduced as well. 
