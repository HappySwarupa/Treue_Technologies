import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Task class representing individual tasks
class Task {
    private String name;
    private LocalDate dueDate;
    private Priority priority;
    private TaskStatus status;

    public Task(String name, LocalDate dueDate, Priority priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.NOT_COMPLETED;
    }

    // Getters and setters (omitted for brevity)

    @Override
    public String toString() {
        return "Task: " + name + ", Due Date: " + dueDate + ", Priority: " + priority + ", Status: " + status;
    }

	public Priority getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}

// Enum for task priority levels
enum Priority {
    HIGH,
    MEDIUM,
    LOW
}

// Enum for task status
enum TaskStatus {
    COMPLETED,
    NOT_COMPLETED
}

// Class representing the TaskReminder application
class TaskReminderApp {
    private List<Task> tasks;

    public TaskReminderApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> tasksByPriority = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                tasksByPriority.add(task);
            }
        }
        return tasksByPriority;
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> tasksByStatus = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                tasksByStatus.add(task);
            }
        }
        return tasksByStatus;
    }

    // Add more methods for managing tasks, setting reminders, etc.

    // Test method
    public static void main(String[] args) {
        TaskReminderApp taskReminderApp = new TaskReminderApp();

        Task task1 = new Task("Finish report", LocalDate.of(2023, 7, 25), Priority.HIGH);
        Task task2 = new Task("Buy groceries", LocalDate.of(2023, 7, 20), Priority.MEDIUM);

        taskReminderApp.addTask(task1);
        taskReminderApp.addTask(task2);

        List<Task> allTasks = taskReminderApp.getTasks();
        System.out.println("All Tasks:");
        for (Task task : allTasks) {
            System.out.println(task);
        }

        List<Task> highPriorityTasks = taskReminderApp.getTasksByPriority(Priority.HIGH);
        System.out.println("\nHigh Priority Tasks:");
        for (Task task : highPriorityTasks) {
            System.out.println(task);
        }
    }
}