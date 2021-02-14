package duke.command;

import java.util.ArrayList;

import duke.task.Task;
import duke.task.TaskList;

public class FindCmd extends Command {
    private final String cmdArgs;

    public FindCmd(String cmdArgs) {
        this.cmdArgs = cmdArgs;
    }

    @Override
    public String execute(TaskList lst) {
        assert lst != null : "TaskList parameter should not be null";

        // Split the search terms and search individually
        String[] wordsToFind = cmdArgs.split(" ");

        ArrayList<Task> result = new ArrayList<>();

        // Refactor this if have time, let the lower-level classes (TaskList and Task) do the bulk of searching.
        // i.e. splitting the words and seeing if Tasks contain those words
        for (String word: wordsToFind) {
            for (Task t: lst.findTasksWithStr(word)) {
                if (!result.contains(t)) {
                    result.add(t);
                }
            }
        }

        if (result.isEmpty()) {
            return String.format("There are no matching tasks in your list for search '%s'.\n", cmdArgs);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Here are the matching tasks in your list for search '%s':\n", cmdArgs));

        // Get the formatting for printing of TaskList
        sb.append(new TaskList(result).toString());
        return sb.toString();
    }
}
