package duke.task;

import duke.util.DateTime;

/**
 * Represents a task that needs to be done by a given deadline.
 */
public class Deadline extends Task {
    private final DateTime by;

    public Deadline(String content, String by) {
        super(content);
        this.by = new DateTime(by);
    }

    private Deadline(String content, boolean isDone, DateTime dt) {
        super(content, isDone);
        this.by = dt;
    }

    public DateTime getBy() {
        return by;
    }

    /**
     * Deserialize the given string to create a Deadline instance. The string should be generated by
     * #getSerialized().
     *
     * @param str the string to deserialize from
     * @return the created Deadline instance
     * @see #getSerialized()
     */
    public static Deadline deserialize(String str) {
        String[] words = str.split(" \\| ");
        boolean isDone = Boolean.parseBoolean(words[1]);
        String content = words[2];

        boolean isDateOnly = Boolean.parseBoolean(words[3]);
        String isoStr = words[4];

        return new Deadline(content, isDone, DateTime.fromISODateTime(isoStr, isDateOnly));
    }

    /**
     * Serialise the Deadline instance to a string where the Deadline instance can be recreated from.
     *
     * @return the serialized Deadline instance
     */
    @Override
    public String getSerialized() {
        return String.format("D | %s | %s | %s | %s", getIsDone(), getContent(),
                by.getDateOnly(), by.toISODateTime());
    }

    /**
     * Returns true if the task contains str in one of its fields
     *
     * @param str the target string
     * @return true if the task contains str in one of its fields
     */
    @Override
    public boolean hasStrInProps(String str) {
        return getContent().contains(str);
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", getStatusIcon(), getContent(), by);
    }
}
