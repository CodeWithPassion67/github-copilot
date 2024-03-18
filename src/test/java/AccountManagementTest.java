// FILEPATH: /c:/Users/adity/Downloads/simplejava/src/test/java/com/github/copilot/AccountManagementTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.copilot.Account;
import com.github.copilot.AccountManagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountManagementTest {
    private AccountManagement accountManagement;
    private Account account1;
    private Account account2;

    @BeforeEach
    public void setup() {
        accountManagement = new AccountManagement();
        account1 = mock(Account.class); // Assume Account is a class that can be mocked
        account2 = mock(Account.class); // Assume Account is a class that can be mocked
    }

    @Test
    public void testAddAccount() {
        accountManagement.addAccount("1", account1);
        assertEquals(account1, accountManagement.fetchOneAccount("1"));
    }

    @Test
    public void testModifyAccount() {
        accountManagement.addAccount("1", account1);
        accountManagement.modifyAccount("1", account2);
        assertEquals(account2, accountManagement.fetchOneAccount("1"));
    }

    @Test
    public void testModifyNonExistingAccount() {
        accountManagement.modifyAccount("1", account1);
        assertNull(accountManagement.fetchOneAccount("1"));
    }

    @Test
    public void testFetchAllAccounts() {
        accountManagement.addAccount("1", account1);
        accountManagement.addAccount("2", account2);
        assertEquals(2, accountManagement.fetchAllAccounts().size());
        assertTrue(accountManagement.fetchAllAccounts().containsKey("1"));
        assertTrue(accountManagement.fetchAllAccounts().containsKey("2"));
    }

    @Test
    public void testFetchOneAccount() {
        accountManagement.addAccount("1", account1);
        assertEquals(account1, accountManagement.fetchOneAccount("1"));
    }

    @Test
    public void testRemoveAccount() {
        accountManagement.addAccount("1", account1);
        accountManagement.removeAccount("1");
        assertNull(accountManagement.fetchOneAccount("1"));
    }

    @Test
    public void testRemoveAllAccounts() {
        accountManagement.addAccount("1", account1);
        accountManagement.addAccount("2", account2);
        accountManagement.removeAllAccounts();
        assertEquals(0, accountManagement.fetchAllAccounts().size());
    }
}