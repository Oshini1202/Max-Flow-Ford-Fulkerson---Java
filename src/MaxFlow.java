/**
 * Algorithm Course work
 * Student name : I.A.Oshini Ilukkumbura
 * IIT Id : 2019757
 * Uow No : w1790248
 *
 * In this program, I used stdlib.jar as a external library.
**/


import java.lang.*;
import java.util.Arrays;
import java.util.LinkedList;

public class MaxFlow {

    static  int V ;                                                                                 // Number of vertices in graph


    static boolean breadthFs(int rGraph[][], int s, int t, int parent[]) {                          // breadth first search method

        boolean visited[] = new boolean[V];                                                         // Create an array called visited
        for (int i = 0; i < V; ++i)
            visited[i] = false;                                                                     // mark all vertices as not visited

        LinkedList<Integer> queue = new LinkedList<Integer>();                                      // create a queue
        queue.add(s);                                                                               // add nodes to queue
        visited[s] = true;                                                                          // mark source vertex as visited
        parent[s] = -1;

        // BFS Loop
        while (queue.size() != 0) {                                                                 // repeat until the queue size not equal to zero
            int u = queue.poll();                                                                   // remove the element at the front the container

            for (int v = 0; v < V; v++) {
                if (visited[v] == false
                        && rGraph[u][v] > 0) {

                    if (v == t) {
                        parent[v] = u;                                                              // If find a connection to the sink have to set its parent
                        return true;                                                                // and return true
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;                                                              // mark as visited
                }
            }
        }

        return false;                                                                               // if the system didn't reach sink in BFS starting from source have to return false
    }


    static int fordFulkerson(int graph[][], int s, int t) {                         // Returns the maximum flow from s to t in the given graph
        int u, v;

        int rGraph[][] = new int[V][V];                                             // Create a residual graph

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];                                         // fill the residual graph with given capacities in the original graph as residual capacities


        int parent[] = new int[V];                                                  // This array is filled by BFS and to store path

        int maxFlow = 0;                                                            // declare maxFlow variable and assign value 0


        while (breadthFs(rGraph, s, t, parent)) {                                   // Augment the flow while there is path from source(s) to sink(t)

            int pathFlow = Integer.MAX_VALUE;

            for (v = t; v != s; v = parent[v]) {                                    // Find minimum residual capacity of edges along the path filled by Breath first search
                u = parent[v];
                pathFlow
                        = Math.min(pathFlow, rGraph[u][v]);
            }


            for (v = t; v != s; v = parent[v]) {                                    // update residual capacities of edges and  reverse edges along the path
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }


            maxFlow += pathFlow;                                                    // Add path flow to max flow
        }

        return maxFlow;                                                             // Return the max flow
    }

    public static void main(String[] args){

        int numOfNodes = 0;                                                                                                   // number of nodes

        In in = new In(args[0]);

        int[] arr = in.readAllInts();                                                                                         // read all int values  from file and store in a array
        numOfNodes=arr[0] ;                                                                                                   // assign node count to numOfNodes variable
        V=arr[0];                                                                                                             // assign node count to V variable
        int size  = arr.length;                                                                                               // assign size of the array into size variable

        int sNode= 0,eNode = 0,edgeCap = 0;                                                                                   // declaring sNode (starting node ), eNode (ending node) and edgeCap (edge capacity) int variables
        System.out.println("Number of Nodes : " +numOfNodes+"\n");                                                            // print the node count
        int[][] graph=new int[numOfNodes][numOfNodes];                                                                        // creating a integer 2D array using node count

        System.out.println("Edges with capacities");
        System.out.println("---------------------");
        int edgeCnt = 0;                                                                                                      // edge count

        int i;
        for (i = 1; i < size; i = i + 3) {
            sNode = arr[i];                                                                                                   // assign the starting node value to sNode variable
            eNode =arr[i+1];                                                                                                  // assign the ending node value to eNode variable
            edgeCap = arr[i +2];                                                                                              // assign the edge capacity to edgeCap variable
            System.out.println("Edge from node " + sNode + " to node " + eNode + " with capacity " + edgeCap);                // print the starting node,ending node and the capacity of a edge
            graph[sNode][eNode]=edgeCap;
            edgeCnt +=1;                                                            // increase the edge count by 1

        }

        System.out.println("\nNumber of edges : "+edgeCnt);                         // print the edge count

        System.out.println("\n"+"Adjacency Matrix");
        System.out.println("-----------------");

        System.out.println();

        for (int[] matrixArr : graph) {                                             // print the adjacency matrix by using a for loop
            System.out.println(Arrays.toString(matrixArr));

        }

        System.out.println();

        MaxFlow mFlow = new MaxFlow();                                              // create an object called mFlow

        long startedTime = System.nanoTime();                                       // get the time input as startedTime before run the algorithm

        int t = numOfNodes - 1;                                                     // get the value of sink node
        System.out.println("The max flow is "
                + mFlow.fordFulkerson(graph, 0, t));                             // print the max flow

        long endedTime = System.nanoTime();                                         // get the time input as endedTime after run the algorithm

        double elapsedNano = (endedTime - startedTime);                             // calculate the elapsed time in nano seconds
        double elapsedMilli = elapsedNano/1000000;                                  // calculate the elapsed time in milli seconds
        System.out.println();
        System.out.println("Elapsed time = " + elapsedNano + " ns");                // print the elapsed time in nano seconds
        System.out.println("Elapsed time = " + elapsedMilli + " ms");               // print the elapsed time in milli seconds


    }


}
