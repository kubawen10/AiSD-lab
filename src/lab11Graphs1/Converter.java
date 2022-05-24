package lab11Graphs1;

import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.AdjacencyMatrixWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;

public class Converter {
    public AdjacencyListWeightedDigraph convert(AdjacencyMatrixWeightedDigraph from) {
        AdjacencyListWeightedDigraph to = new AdjacencyListWeightedDigraph(from.vertexCount());

        return (AdjacencyListWeightedDigraph) copy(from, to);
    }

    public AdjacencyMatrixWeightedDigraph convert(AdjacencyListWeightedDigraph from) {
        AdjacencyMatrixWeightedDigraph to = new AdjacencyMatrixWeightedDigraph(from.vertexCount());

        return (AdjacencyMatrixWeightedDigraph) copy(from, to);
    }

    private IWeightedDigraph copy(IWeightedDigraph copyFrom, IWeightedDigraph copyTo){
        int vertexCount = copyFrom.vertexCount();
        double weight;

        for (int from = 0; from < vertexCount; from++) {
            for (int to = 0; to < vertexCount; to++){
                weight = copyFrom.weight(from, to);

                if(!Double.isInfinite(weight)){
                    copyTo.addEdge(from, to, weight);
                }
            }
        }

        return copyTo;
    }

//    public AdjacencyListWeightedDigraph convert(AdjacencyMatrixWeightedDigraph graph) {
//        int vertexCount = graph.vertexCount();
//        AdjacencyListWeightedDigraph converted = new AdjacencyListWeightedDigraph(vertexCount);
//
//        double weight;
//        for (int from = 0; from < vertexCount; from++) {
//            for (int to = 0; to < vertexCount; to++){
//                weight = graph.weight(from, to);
//
//                if(!Double.isInfinite(weight)){
//                    converted.addEdge(from, to, weight);
//                }
//            }
//        }
//
//        return converted;
//    }
}
