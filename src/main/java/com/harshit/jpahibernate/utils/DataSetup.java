package com.harshit.jpahibernate.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.harshit.jpahibernate.repository.AccountRepository;
import com.harshit.jpahibernate.repository.model.Account;
import com.harshit.jpahibernate.repository.model.Groups;
import com.harshit.jpahibernate.service.SetupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSetup {
    private Logger logger = LoggerFactory.getLogger(DataSetup.class);
    private static final String ACCOUNTS_FILE = "csv/accounts.csv";
    private static final String GROUPS_FILE = "csv/groups.csv";
    private static final String GROUP_ACCOUNTS = "csv/group_accounts.csv";

    @Autowired
    private SetupService service;

    @PostConstruct
    private void loadObjectsFromCSV() {
        setupAccountsAndGroups();
    }

    private List<Account> getAccountsDataFromCSV() {
        return CsvUtils.read(Account.class, ACCOUNTS_FILE);
        // accounts.stream().forEach(account -> logger.info("Account is: -> {}", account));
        // accountRepository.saveAll(accounts);
    }

    private List<Groups> getGroupsDataFromCSV() {
        // logger.info("Inside groups Data from csv");
        List<Account> accounts = this.getAccountsDataFromCSV();
        List<Groups> groups = CsvUtils.read(Groups.class, GROUPS_FILE);
        List<String[]> groupAccountsList = CsvUtils.loadManyToManyRelationship(GROUP_ACCOUNTS);

        for(String[] groupAccounts: groupAccountsList) {
            Groups group = findGroupById(groups, groupAccounts[1]);
            Set<Account> setOfAccounts = group.getAccounts();
            if(setOfAccounts == null) {
                setOfAccounts = new HashSet<>();
            }
            setOfAccounts.add(findAccountById(accounts, groupAccounts[0]));
            group.setAccounts(setOfAccounts);
        }
        logger.info("The list of groups is: -> {}", groups.get(0));
        return groups;    
    }

    private Groups findGroupById(List<Groups> groups, String groupId) {
        return groups.stream().filter(group -> group.getGroupId().equals(groupId)).findAny().orElse(null);
    }

    private Account findAccountById(List<Account> allAccounts, String accountId) {
        return allAccounts.stream().filter(account -> account.getAccountId().equals(accountId)).findAny().orElse(null);
    }

    private void setupAccountsAndGroups() {
        List<Account> accounts = getAccountsDataFromCSV();
        for(Account account: accounts) {
            service.setUpAcount(account);
        }

        List<Groups> groups = getGroupsDataFromCSV();
        for (Groups group : groups) {
            service.setUpGroup(group);   
        }
    }


}