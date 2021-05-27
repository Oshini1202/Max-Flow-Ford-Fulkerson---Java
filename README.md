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

## Performance analysis of the algorithmic design and implementation
![image](https://user-images.githubusercontent.com/66233975/119770374-c065a680-bed9-11eb-9d4e-b5a4c0be7180.png)

![image](https://user-images.githubusercontent.com/66233975/119770524-edb25480-bed9-11eb-9c9f-ca16b5796bb4.png)

For that implementation, I used 4 text data files which includes 6 ,12, 24,48 number of vertices respectively to apply doubling hypothesis in there. And the number of edges include in those files also have a respective doubling pattern. I ran all the text files 5 times and got the average time spent and put it there as the elapsed time.   As the above graph and table, four nodes are utilized in order to calculate the time period and because the number of nodes used is high, the accuracy of the graph is additionally high. As the above table, when the number of nodes increases the time spent for the calculation of maximum flow also increases. Because of that reason the graph takes the shape of a positive quadratic equation. From node 24 to 48, gradient of the graph has increased rapidly. According to the quadratic function shape of the graph, time complexity also takes a shape of a quadratic function and it called quadratic time.And also this algorithm has two nested for loops. Therefore, the Big-O notation can represent as below.

![image](https://user-images.githubusercontent.com/66233975/119771128-d162e780-beda-11eb-8ded-6e21b9026507.png)

