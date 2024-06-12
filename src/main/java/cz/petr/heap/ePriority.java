package cz.petr.heap;

/**
 *
 * @author Petr
 */
public enum ePriority {
    POPULATION("Population"),
    NAME("Name of the municipality");

    private String type;

    private ePriority(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Enum[] getPriorityTypes() {
        Enum[] priority = {POPULATION, NAME};
        return priority;
    }

    @Override
    public String toString() {
        return type;
    }

}
