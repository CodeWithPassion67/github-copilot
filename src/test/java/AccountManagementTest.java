// FILEPATH: /c:/Users/adity/Downloads/simplejava/src/test/java/com/github/copilot/AccountManagementTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.copilot.Account;
import com.github.copilot.AccountManagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This class contains unit tests for the AccountManagement class.
 */
public class AccountManagementTest {
    private AccountManagement accountManagement;
    private Account account1;
    private Account account2;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setup() {
        accountManagement = new AccountManagement();
        account1 = mock(Account.class); // Assume Account is a class that can be mocked
        account2 = mock(Account.class); // Assume Account is a class that can be mocked
    }

    /**
     * Tests the addAccount method of AccountManagement.
     * It verifies that the account is added successfully and can be fetched using the provided ID.
     */
    @Test
    public void testAddAccount() {
        accountManagement.addAccount("1", account1);
        assertEquals(account1, accountManagement.fetchOneAccount("1"));
    }

    /**
     * Tests the modifyAccount method of AccountManagement.
     * It verifies that the account with the provided ID is modified successfully.
     */
    @Test
    public void testModifyAccount() {
        accountManagement.addAccount("1", account1);
        accountManagement.modifyAccount("1", account2);
        assertEquals(account2, accountManagement.fetchOneAccount("1"));
    }

    /**
     * Tests the modifyAccount method of AccountManagement when the account does not exist.
     * It verifies that no account is modified when the provided ID does not exist.
     */
    @Test
    public void testModifyNonExistingAccount() {
        accountManagement.modifyAccount("1", account1);
        assertNull(accountManagement.fetchOneAccount("1"));
    }

    /**
     * Tests the fetchAllAccounts method of AccountManagement.
     * It verifies that all accounts are fetched correctly and the expected number of accounts is returned.
     */
    @Test
    public void testFetchAllAccounts() {
        accountManagement.addAccount("1", account1);
        accountManagement.addAccount("2", account2);
        assertEquals(2, accountManagement.fetchAllAccounts().size());
        assertTrue(accountManagement.fetchAllAccounts().containsKey("1"));
        assertTrue(accountManagement.fetchAllAccounts().containsKey("2"));
    }

    /**
     * Tests the fetchOneAccount method of AccountManagement.
     * It verifies that the account with the provided ID is fetched correctly.
     */
    @Test
    public void testFetchOneAccount() {
        accountManagement.addAccount("1", account1);
        assertEquals(account1, accountManagement.fetchOneAccount("1"));
    }

    /**
     * Tests the removeAccount method of AccountManagement.
     * It verifies that the account with the provided ID is removed successfully.
     */
    @Test
    public void testRemoveAccount() {
        accountManagement.addAccount("1", account1);
        accountManagement.removeAccount("1");
        assertNull(accountManagement.fetchOneAccount("1"));
    }

    /**
     * Tests the removeAllAccounts method of AccountManagement.
     * It verifies that all accounts are removed successfully.
     */
    @Test
    public void testRemoveAllAccounts() {
        accountManagement.addAccount("1", account1);
        accountManagement.addAccount("2", account2);
        accountManagement.removeAllAccounts();
    }
}