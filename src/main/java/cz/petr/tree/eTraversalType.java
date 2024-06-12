package cz.petr.tree;

/**
 *
 * @author Petr
 */
public enum eTraversalType {
    BREADTH("Breadth"),
    DEPTH("Depth");

    private String type;

    private eTraversalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Enum[] getTraversalTypes() {
        Enum[] traversalTypes = {DEPTH, BREADTH};
        return traversalTypes;
    }

    @Override
    public String toString() {
        return type;
    }
}
