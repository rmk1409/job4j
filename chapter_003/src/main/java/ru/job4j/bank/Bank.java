package ru.job4j.bank;

import java.util.*;

/**
 * Created by roman.pogorelov on 01.09.2019
 */
public class Bank {
    // TODO find where we can use "List.indexOf"

    /**
     * Users
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method adds new user.
     *
     * @param user new entity
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method deletes the user.
     *
     * @param user entity for deleting
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Method adds the account to the user.
     *
     * @param passport is used to find the user
     * @param account  new account
     */
    public void addAccountToUser(String passport, Account account) {
        this.users.entrySet()
                .stream()
                .filter(i -> passport.equals(i.getKey().getPassword()))
                .findFirst()
                .ifPresent(i -> i.getValue().add(account));
    }

    /**
     * Method deletes the account from the user.
     *
     * @param passport is used to find the user
     * @param account  is used for removing
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.users.entrySet()
                .stream()
                .filter(i -> passport.equals(i.getKey().getPassword()))
                .findFirst()
                .ifPresent(i -> i.getValue().remove(account));
    }

    /**
     * Method returns list of all user accounts.
     *
     * @param passport is used to find the user
     * @return list of all user accounts
     */
    public List<Account> getUserAccounts(String passport) {
        return this.users.entrySet()
                .stream()
                .filter(i -> passport.equals(i.getKey().getPassword()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
    }

    /**
     * Method transfers money from one Account to another.
     *
     * @param srcPassport  is used to find the src User
     * @param srcRequisite is used to find the src Account
     * @param destPassport is used to find the dest User
     * @param dstRequisite is used to find the dest Account
     * @param amount       money for the transfer
     * @return whether it is successful or not
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account src = this.getAccount(srcPassport, srcRequisite);
        Account dest = this.getAccount(destPassport, dstRequisite);
        return (src != null) && (src.transferMoney(dest, amount));
    }

    /**
     * Method finds Account by passport and requisite.
     *
     * @param passport  User data
     * @param requisite Account data
     * @return found account or null
     */
    private Account getAccount(String passport, String requisite) {
        return this.getUserAccounts(passport)
                .stream()
                .filter(i -> requisite.equals(i.getRequisites()))
                .findFirst()
                .orElse(null);
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public void setUsers(Map<User, List<Account>> users) {
        this.users = users;
    }
}
