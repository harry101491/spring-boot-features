package com.harshit.jpahibernate.service;

import java.util.HashSet;
import java.util.Set;

import com.harshit.jpahibernate.repository.AccountRepository;
import com.harshit.jpahibernate.repository.GroupsRepository;
import com.harshit.jpahibernate.repository.model.Account;
import com.harshit.jpahibernate.repository.model.Groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    public void setUpAcount(Account account) {
        if(accountRepository.findById(account.getAccountId()) == null) {
            accountRepository.save(account);
        }
    }

    public void setUpGroup(Groups group) {
        if(groupsRepository.findById(group.getGroupId()) == null) {
            Set<Account> setOfAccounts = group.getAccounts();
            Set<Account> persistedAccounts = new HashSet<>();
            for(Account account: setOfAccounts) {
                persistedAccounts.add(accountRepository.findById(account.getAccountId()).orElse(null));
            }
            group.setAccounts(persistedAccounts);
            groupsRepository.save(group);
        }
    }
}