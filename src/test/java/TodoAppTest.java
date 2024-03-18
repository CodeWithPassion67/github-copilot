import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.copilot.Todo;
import com.github.copilot.TodoApp;

import static org.junit.jupiter.api.Assertions.*;

// FILEPATH: /c:/Users/adity/Downloads/simplejava/src/test/java/com/github/copilot/TodoAppTest.java
/**
 * This class contains unit tests for the TodoApp class.
 */
public class TodoAppTest {
    private TodoApp todoApp;
    private Todo todo1;
    private Todo todo2;

    /**
     * Sets up the test environment before each test method is executed.
     */
    @BeforeEach
    public void setup() {
        todoApp = new TodoApp();
        todo1 = new Todo(); // Assume Todo has a default constructor
        todo2 = new Todo(); // Assume Todo has a default constructor
    }

    /**
     * Tests the add() method of TodoApp.
     */
    @Test
    public void testAdd() {
        todoApp.add(todo1);
        assertEquals(1, todoApp.fetchTodo().size());
        assertTrue(todoApp.fetchTodo().contains(todo1));
    }

    /**
     * Tests the update() method of TodoApp.
     */
    @Test
    public void testUpdate() {
        todoApp.add(todo1);
        todoApp.update(0, todo2);
        assertEquals(1, todoApp.fetchTodo().size());
        assertTrue(todoApp.fetchTodo().contains(todo2));
        assertFalse(todoApp.fetchTodo().contains(todo1));
    }

    /**
     * Tests the update() method of TodoApp with an invalid index.
     */
    @Test
    public void testUpdateInvalidIndex() {
        todoApp.add(todo1);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            todoApp.update(1, todo2);
        });
        String expectedMessage = "Invalid index";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Tests the remove() method of TodoApp.
     */
    @Test
    public void testRemove() {
        todoApp.add(todo1);
        todoApp.add(todo2);
        todoApp.remove("Todo 1");
        assertEquals(1, todoApp.fetchTodo().size());
        assertFalse(todoApp.fetchTodo().contains(todo1));
        assertTrue(todoApp.fetchTodo().contains(todo2));
    }

    /**
     * Tests the remove() method of TodoApp with a non-existing todo.
     */
    @Test
    public void testRemoveNonExistingTodo() {
        todoApp.add(todo1);
        todoApp.add(todo2);
        todoApp.remove("Non-existing Todo");
        assertEquals(2, todoApp.fetchTodo().size());
        assertTrue(todoApp.fetchTodo().contains(todo1));
        assertTrue(todoApp.fetchTodo().contains(todo2));
    }

    /**
     * Tests the removeAll() method of TodoApp.
     */
    @Test
    public void testRemoveAll() {
        todoApp.add(todo1);
        todoApp.add(todo2);
        todoApp.removeAll();
        assertEquals(0, todoApp.fetchTodo().size());
        assertFalse(todoApp.fetchTodo().contains(todo1));
        assertFalse(todoApp.fetchTodo().contains(todo2));
    }
}

