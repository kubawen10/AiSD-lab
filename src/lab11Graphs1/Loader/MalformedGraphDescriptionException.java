package lab11Graphs1.Loader;

public class MalformedGraphDescriptionException extends Exception{
    public MalformedGraphDescriptionException(String description, int lineNumber) {
        super("LineNumber: " + lineNumber + "; Description: " + description);
    }
}
