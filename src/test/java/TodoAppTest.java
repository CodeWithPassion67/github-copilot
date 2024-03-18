import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.copilot.Todo;
import com.github.copilot.TodoApp;

import static org.junit.jupiter.api.Assertions.*;

// FILEPATH: /c:/Users/adity/Downloads/simplejava/src/test/java/com/github/copilot/TodoAppTest.java
public class TodoAppTest {
    private TodoApp todoApp;
    private Todo todo1;
    private Todo todo2;

    @BeforeEach
    public void setup() {
        todoApp = new TodoApp();
        todo1 = new Todo(); // Assume Todo has a default constructor
        todo2 = new Todo(); // Assume Todo has a default constructor
    }

    @Test
    public void testAdd() {
        todoApp.add(todo1);
        assertEquals(1, todoApp.fetchTodo().size());
        assertTrue(todoApp.fetchTodo().contains(todo1));
    }

    @Test
    public void testUpdate() {
        todoApp.add(todo1);
        todoApp.update(0, todo2);
        assertEquals(1, todoApp.fetchTodo().size());
        assertTrue(todoApp.fetchTodo().contains(todo2));
        assertFalse(todoApp.fetchTodo().contains(todo1));
    }

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

   

@Test
public void testRemove() {
    todoApp.add(todo1);
    todoApp.add(todo2);
    todoApp.remove("Todo 1");
    assertEquals(1, todoApp.fetchTodo().size());
    assertFalse(todoApp.fetchTodo().contains(todo1));
    assertTrue(todoApp.fetchTodo().contains(todo2));
}

@Test
public void testRemoveNonExistingTodo() {
    todoApp.add(todo1);
    todoApp.add(todo2);
    todoApp.remove("Non-existing Todo");
    assertEquals(2, todoApp.fetchTodo().size());
    assertTrue(todoApp.fetchTodo().contains(todo1));
    assertTrue(todoApp.fetchTodo().contains(todo2));
}

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

