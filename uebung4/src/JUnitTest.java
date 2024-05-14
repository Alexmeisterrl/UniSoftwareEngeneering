import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserStoryManagerTest {
    @Test
    void testAddStory() {
        UserStoryManager manager = new UserStoryManager();
        manager.addStory(1, "Test User Story", "Must Have");
        assertEquals(1, manager.getStories().size());
    }

    @Test
    void testAddTask() {
        UserStoryManager manager = new UserStoryManager();
        manager.addStory(1, "Test User Story", "Must Have");
        manager.addTask(1, "Test Task");
        assertEquals(1, manager.getStories().get(0).getTasks().size());
    }

    @Test
    void testAssignTask() {
        UserStoryManager manager = new UserStoryManager();
        manager.addStory(1, "Test User Story", "Must Have");
        manager.addTask(1, "Test Task");
        manager.assignTask(1, 1);
        assertEquals(1, manager.getStories().get(0).getTasks().size());
    }

    @Test
    void testSaveAndLoad() {
        UserStoryManager manager = new UserStoryManager();
        manager.addStory(1, "Test User Story", "Must Have");
        manager.addTask(1, "Test Task");
        manager.saveToFile("test_file.txt");

        UserStoryManager loadedManager = new UserStoryManager();
        loadedManager.loadFromFile("test_file.txt");
        assertEquals(manager.getStories().size(), loadedManager.getStories().size());
        assertEquals(manager.getStories().get(0).getTasks().size(), loadedManager.getStories().get(0).getTasks().size());
    }
}