import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class TaskCommand extends Command {
  
  public TaskCommand(String name, Map<String, Object> args) {
    super(name, args);
  }

  protected abstract Task makeTask() throws DukeException;

  @Override
  public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
    Task newTask = this.makeTask();
    tasks.add(newTask);
    ui.print(String.format("Got it. I've added this task:\n  %s\n%s", tasks.get(tasks.size()).toString(), ui.getTaskCount(tasks.size())));;
  }

  @Override
  public boolean isExit() {
    return false;
  }

}
