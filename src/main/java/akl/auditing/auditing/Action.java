package akl.auditing.auditing;

public enum Action {
    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private String name;

    private Action(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
