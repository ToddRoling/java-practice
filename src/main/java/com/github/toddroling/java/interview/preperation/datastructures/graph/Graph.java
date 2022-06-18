package com.github.toddroling.java.interview.preperation.datastructures.graph;

import java.util.ArrayList;

public interface Graph {

    ArrayList<Integer> breadthFirstSearch(final ArrayList<ArrayList<Integer>> adjacencyList);

    ArrayList<Integer> depthFirstSearch(final ArrayList<ArrayList<Integer>> adjacencyList);
}
