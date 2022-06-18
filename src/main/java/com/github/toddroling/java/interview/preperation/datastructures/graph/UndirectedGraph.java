package com.github.toddroling.java.interview.preperation.datastructures.graph;

import java.util.*;

public final class UndirectedGraph implements Graph {

    private final ArrayList<Integer> traversalResult = new ArrayList<>();
    private final Set<Integer> visitedNodes = new HashSet<>();

    ArrayList<ArrayList<Integer>> adjacencyList;

    // My solution to https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        return breadthFirstSearch(adj);
    }

    @Override
    public ArrayList<Integer> breadthFirstSearch(final ArrayList<ArrayList<Integer>> adjacencyList) {
        traversalResult.clear();
        if (adjacencyList == null || adjacencyList.isEmpty()) {
            return traversalResult;
        }
        final Queue<Integer> queue = new LinkedList<>(List.of(0));
        visitedNodes.clear();

        while (!queue.isEmpty()) {
            final int node = queue.poll();
            if (!visitedNodes.contains(node)) {
                traversalResult.add(node);
                visitedNodes.add(node);
                for (final Integer neighbor : adjacencyList.get(node)) {
                    if (!visitedNodes.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return traversalResult;
    }

    // My solution to https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        return depthFirstSearch(adj);
    }

    @Override
    public ArrayList<Integer> depthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList) {
        traversalResult.clear();
        if (adjacencyList == null || adjacencyList.isEmpty()) {
            return traversalResult;
        }
        this.adjacencyList = adjacencyList;
        visitedNodes.clear();
        return depthFirstSearchHelper(0);
    }

    private ArrayList<Integer> depthFirstSearchHelper(final Integer node) {
        if (node != null) {
            if (!visitedNodes.contains(node)) {
                traversalResult.add(node);
                visitedNodes.add(node);
                for (Integer neighbor : adjacencyList.get(node)) {
                    depthFirstSearchHelper(neighbor);
                }
            }
        }
        return traversalResult;
    }
}
