package duke.command;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;

public class DeleteCmd extends Command {
    private final String cmdArgs;

    public DeleteCmd(String cmdArgs) {
        this.cmdArgs = cmdArgs;
    }

    @Override
    public String execute(TaskList lst) {
        int idx = Integer.parseInt(cmdArgs) - 1;
        if (idx < 0 || idx >= lst.size()) {
            throw new DukeException(String.format("Item no. %d cannot be found in list", idx + 1));
        }

        Task t = lst.remove(idx);
        return "Noted. I've removed this task:\n"
            + String.format("\t%s\n", t.toString())
            + String.format("Now you have %d tasks in the list\n", lst.size());
    }
}
