package com.harshit.jpahibernate.repository.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    
    @Id
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_name")
    private String accountName;

    @ManyToMany
    @JoinTable(name = "GROUP_ACCOUNTS",
        joinColumns = @JoinColumn(name = "accountId"),
        inverseJoinColumns = @JoinColumn(name = "groupId"))
    private Set<Groups> groups;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Account [accountName=" + accountName + ", accountId=" + accountId + "]";
    }
}