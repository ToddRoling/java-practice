package local.unit;

import com.github.toddroling.java.practice.datastructures.graph.UndirectedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UndirectedGraphTest {

    private static final ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    private static final UndirectedGraph undirectedGraph = new UndirectedGraph();

    @BeforeAll
    public static void beforeAllUndirectedGraphTest() {
        adjacencyList.add(new ArrayList<>(List.of(1, 3)));
        adjacencyList.add(new ArrayList<>(List.of(0, 2, 4)));
        adjacencyList.add(new ArrayList<>(List.of(1, 4, 6)));
        adjacencyList.add(new ArrayList<>(List.of(0, 5)));
        adjacencyList.add(new ArrayList<>(List.of(1, 2)));
        adjacencyList.add(new ArrayList<>(List.of(1, 3)));
        adjacencyList.add(new ArrayList<>(List.of(2)));
    }

    @Test
    void bfsOfGraph() {
        final ArrayList<Integer> actualResult = undirectedGraph.bfsOfGraph(7, adjacencyList);
        final ArrayList<Integer> expectedResult = new ArrayList<>(List.of(0, 1, 3, 2, 4, 5, 6));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void dfsOfGraph() {
        final ArrayList<Integer> actualResult = undirectedGraph.dfsOfGraph(7, adjacencyList);
        final ArrayList<Integer> expectedResult = new ArrayList<>(List.of(0, 1, 2, 4, 6, 3, 5));
        assertEquals(expectedResult, actualResult);
    }
}
