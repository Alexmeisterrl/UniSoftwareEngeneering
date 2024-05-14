import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserStoryManager {
    private List<UserStory> userStories;

    public UserStoryManager() {
        this.userStories = new ArrayList<>();
    }
    public int size() {
        return userStories.size();
    }

    public void addStory(int id, String description, String priority) {
        userStories.add(new UserStory(id, description, priority));
    }

    public void addTask(int id, String description) {
        userStories.get(userStories.size() - 1).addTask(new Task(id, description));
    }

    public void assignTask(int storyId, int taskId) {
        for (UserStory story : userStories) {
            if (story.getId() == storyId) {
                for (Task task : story.getTasks()) {
                    if (task.getId() == taskId) {
                        System.out.println("Task mit ID " + taskId + " wurde erfolgreich User Story mit ID " + storyId + " zugeordnet.");
                        return;
                    }
                }
            }
        }
        System.out.println("Fehler: User Story oder Task nicht gefunden.");
    }

    public void listStories() {
        for (UserStory story : userStories) {
            System.out.println("ID: " + story.getId() + ", Beschreibung: " + story.getDescription() + ", Priorität: " + story.getPriority());
            if (!story.getTasks().isEmpty()) {
                System.out.println("Zugeordnete Tasks:");
                for (Task task : story.getTasks()) {
                    System.out.println("Task ID: " + task.getId() + ", Beschreibung: " + task.getDescription());
                }
            } else {
                System.out.println("Keine zugeordneten Tasks.");
            }
        }
    }

    public void listTasks() {
        for (UserStory story : userStories) {
            for (Task task : story.getTasks()) {
                System.out.println("ID: " + task.getId() + ", Beschreibung: " + task.getDescription());
            }
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (UserStory story : userStories) {
                writer.println("Story|" + story.getId() + "|" + story.getDescription() + "|" + story.getPriority());
                for (Task task : story.getTasks()) {
                    writer.println("Task|" + task.getId() + "|" + task.getDescription());
                }
            }
            System.out.println("User Stories und Tasks wurden erfolgreich gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei.");
        }
    }

    public void loadFromFile(String filename) {
        userStories.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            UserStory currentStory = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals("Story")) {
                    currentStory = new UserStory(Integer.parseInt(parts[1]), parts[2], parts[3]);
                    userStories.add(currentStory);
                } else if (parts[0].equals("Task") && currentStory != null) {
                    currentStory.addTask(new Task(Integer.parseInt(parts[1]), parts[2]));
                }
            }
            System.out.println("User Stories und Tasks wurden erfolgreich geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei.");
        }
    }

    public static void main(String[] args) {
        UserStoryManager manager = new UserStoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ", 2);
            String command = input[0].toLowerCase();
            String[] params = input.length > 1 ? input[1].split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?") : new String[0];

            switch (command) {
                case "story":
                    manager.addStory(Integer.parseInt(params[0]), params[1], params[2]);
                    break;
                case "task":
                    manager.addTask(Integer.parseInt(params[0]), params[1]);
                    break;
                case "assign":
                    manager.assignTask(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
                    break;
                case "stories":
                    manager.listStories();
                    break;
                case "tasks":
                    manager.listTasks();
                    break;
                case "save":
                    manager.saveToFile("user_stories.txt");
                    break;
                case "load":
                    manager.loadFromFile("user_stories.txt");
                    break;
                default:
                    System.out.println("Unbekannter Befehl.");
                    break;
            }
        }
    }

    public List<UserStory> getStories() {
        return userStories;
    }
}