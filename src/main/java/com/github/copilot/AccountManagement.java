package com.github.copilot;

import java.util.HashMap;
import java.util.Map;

/**
 * The AccountManagement class represents a system for managing accounts.
 * It provides methods for adding, modifying, fetching, and removing accounts.
 */
public class AccountManagement {
    private Map<String, Account> accountMap;

    /**
     * Constructs an AccountManagement object with an empty account map.
     */
    public AccountManagement() {
        accountMap = new HashMap<>();
    }

    /**
     * Adds an account to the account map.
     *
     * @param accountId The ID of the account.
     * @param account   The account to be added.
     */
    public void addAccount(String accountId, Account account) {
        accountMap.put(accountId, account);
    }

    /**
     * Modifies an existing account in the account map.
     *
     * @param accountId      The ID of the account to be modified.
     * @param modifiedAccount The modified account.
     */
    public void modifyAccount(String accountId, Account modifiedAccount) {
        if (accountMap.containsKey(accountId)) {
            accountMap.put(accountId, modifiedAccount);
        } else {
            System.out.println("Account not found!");
        }
    }

    /**
     * Returns a map containing all the accounts.
     *
     * @return A map containing all the accounts.
     */
    public Map<String, Account> fetchAllAccounts() {
        return accountMap;
    }

    /**
     * Returns the account with the specified ID.
     *
     * @param accountId The ID of the account to fetch.
     * @return The account with the specified ID, or null if not found.
     */
    public Account fetchOneAccount(String accountId) {
        return accountMap.get(accountId);
    }

    /**
     * Removes the account with the specified ID from the account map.
     *
     * @param accountId The ID of the account to be removed.
     */
    public void removeAccount(String accountId) {
        accountMap.remove(accountId);
    }

    /**
     * Removes all accounts from the account map.
     */
    public void removeAllAccounts() {
        accountMap.clear();
    }
}