package lab11Graphs1.Loader;

import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.AdjacencyMatrixWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Loader {
    public static AdjacencyMatrixWeightedDigraph matrixGraphLoader(String path) {
        ArrayList<String> lines = loadLines(path);
        AdjacencyMatrixWeightedDigraph graph = null;
        try {
            checkEmptyFileException(lines);
            int numberOfVertices = loadNumberOfVertices(lines.get(0));
            graph = new AdjacencyMatrixWeightedDigraph(numberOfVertices);
            loadArcs(graph, lines);
        } catch (MalformedGraphDescriptionException e) {
            System.out.println(e);
        }

        return graph;
    }

    public static AdjacencyListWeightedDigraph listGraphLoader(String path) {
        ArrayList<String> lines = loadLines(path);
        AdjacencyListWeightedDigraph graph = null;
        try {
            checkEmptyFileException(lines);
            int numberOfVertices = loadNumberOfVertices(lines.get(0));
            graph = new AdjacencyListWeightedDigraph(numberOfVertices);
            loadArcs(graph, lines);
        } catch (MalformedGraphDescriptionException e) {
            System.out.println(e);
        }

        return graph;
    }

    private static void loadArcs(IWeightedDigraph graph, ArrayList<String> lines) {
        String currentLine;
        String[] args;

        boolean undirected;
        int u;
        int v;
        double w;

        for (int i = 1; i < lines.size(); i++) {
            currentLine = lines.get(i);

            args = currentLine.split("\\s+");

            undirected = false;
            if (args.length == 4) {
                try {
                    undirected = isUndirected(args[0], i + 1);
                } catch (MalformedGraphDescriptionException e) {
                    System.out.println(e);
                    continue;
                }

                args = Arrays.copyOfRange(args, 1, args.length);
            }

            if (args.length == 3) {
                try {
                    u = parseVertex(args[0], i + 1);
                    v = parseVertex(args[1], i + 1);
                    w = parseWeight(args[2], i + 1);
                    loadToGraph(undirected, u, v, w, graph, i + 1);
                } catch (MalformedGraphDescriptionException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    throw new MalformedGraphDescriptionException("Unsupported number of arguments. ", i + 1);
                } catch (MalformedGraphDescriptionException e) {
                    System.out.println(e);
                }
            }
        }
    }

    //adding arc to graph, if args arent correct it is handled by graph itself
    private static void loadToGraph(boolean undirected, int u, int v, double w, IWeightedDigraph graph, int line) throws MalformedGraphDescriptionException {
        boolean added;
        if (undirected) {
            added = graph.addEdgeU(u, v, w);
        } else {
            added = graph.addEdge(u, v, w);
        }

        if (!added) {
            throw new MalformedGraphDescriptionException("Couldn't add edge. ", line);
        }
    }

    //parse vertex arg as int
    private static int parseVertex(String arg, int line) throws MalformedGraphDescriptionException {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new MalformedGraphDescriptionException("Wrong vertex argument. Expected: int, got: " + arg, line);
        }
    }

    //parsing weight arg as double
    private static double parseWeight(String arg, int line) throws MalformedGraphDescriptionException {
        try {
            return Double.parseDouble(arg);
        } catch (NumberFormatException e) {
            throw new MalformedGraphDescriptionException("Wrong weight argument. Expected: int, got: " + arg, line);
        }
    }

    //checking for parameter "u"
    private static boolean isUndirected(String character, int line) throws MalformedGraphDescriptionException {
        if ("u".equals(character)) {
            return true;
        }

        throw new MalformedGraphDescriptionException("Unexpected argument. Expected: \"u\", got: \"" + character + "\"", line);
    }

    //using first line as number of vertices, loading it as int
    private static int loadNumberOfVertices(String line) throws MalformedGraphDescriptionException {
        //remove leading and trailing whitespaces
        line = line.trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new MalformedGraphDescriptionException("Number of vertices is not an integer. Expected: int, got: " + line, 1);
        }
    }

    //checking if file is empty
    private static void checkEmptyFileException(ArrayList<String> lines) throws MalformedGraphDescriptionException {

        if (lines.size() == 0) {
            throw new MalformedGraphDescriptionException("File is empty!", 0);
        }
    }

    //loading file and saving it in arrayList of lines
    private static ArrayList<String> loadLines(String path) {

        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = null;
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lines;
    }
}
