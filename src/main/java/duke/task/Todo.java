package duke.task;

/**
 * Represents a task that needs to be done.
 */
public class Todo extends Task {
    public Todo(String content) {
        super(content);
    }

    /**
     * Deserialize the given string to create a Todo instance. The string should be generated by #getSerialized().
     *
     * @param str the string to deserialize from
     * @return the created Todo instance
     * @see #getSerialized()
     */
    public static Todo deserialize(String str) {
        String[] words = str.split(" \\| ");
        boolean isDone = Boolean.parseBoolean(words[1]);
        String content = words[2];

        Todo todo = new Todo(content);
        if (isDone) {
            todo.markDone();
        }

        return todo;
    }

    /**
     * Serialise the Todo instance to a string where the Todo instance can be recreated from.
     *
     * @return the serialized Todo instance
     */
    @Override
    public String getSerialized() {
        return String.format("T | %s | %s", getIsDone(), getContent());
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
        return String.format("[T][%s] %s", getStatusIcon(), getContent());
    }
}
