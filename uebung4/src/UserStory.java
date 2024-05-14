import java.util.ArrayList;
import java.util.List;

class UserStory {
    private int id;
    private String description;
    private String priority;
    private List<Task> tasks;

    public UserStory(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}