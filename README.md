# Max-Flow-Ford-Fulkerson---Java

## Chosen algorithms
This maximum possible flow implementation of Ford Fulkerson Algorithm is called Edmonds-Karp algorithm and part from that breadth-first search algorithm is additionally used in that. 
Flow network is a directed graph where each edge has a capacity and a flow. Ford-Fulkerson algorithm is a greedy algorithm and it uses to compute the maximum flow in a flow network.

The steps on that algorithm are mentioned below.
* Find a path from source(s) to sink(t)
* After solving this path, it finds another path by using available capacities on all the edges in that particular path and this process called augmented path. After that it will find another path and continues the process.

I used Breadth First Search (BFS) to find if there a path exists from source(s) to sink(t). The reason for selecting BFS was because it always picks up the path with the minimum number of edges and the worst case time complexity can be reduced as well. 

## Chosen data structure
In my solution, I used Linked List queue to store the visited nodes temporary. And I used queue.poll() method to remove the element at the front of the container. If the queue is equal to the value zero, we can assume that the algorithm has stopped.

I used a 2D array as the main array of my program to store graphs as a matrix.I  used array named parent array in Ford Fulkerson method to store already visited nodes. I added data to that array in breadthFs method and I created another boolean array named as visited . Using that array can check whether a node is visited or not.

In file reading part, I used an array called arr to store the int values was in the text file. And used an array called matrixArr to print the adjacency matrix through a for loop. The reason for using arrays in my solution is because, the ability of storing large data, can easily access any element randomly by using indexes because we already know the array size and data type. 

## Outputs of bridge_1.txt
![image](https://user-images.githubusercontent.com/66233975/119770132-6bc22b80-bed9-11eb-8db6-afcca8c31232.png)
![image](https://user-images.githubusercontent.com/66233975/119770143-71b80c80-bed9-11eb-8f09-447dabe31e27.png)

As shown in above, first I printed the number of nodes, then each edge’s starting node, ending node with its capacity, no of edges in the graph, adjacency matrix of the graph, calculated max flow value and finally the elapsed time in nanoseconds and milliseconds.



