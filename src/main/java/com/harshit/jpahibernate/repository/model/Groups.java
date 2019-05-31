package com.harshit.jpahibernate.repository.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Groups {
    
    @Id
    @Column(name = "groupId")
    private String groupId;

    @Column(name = "group_name")
    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private Set<Account> accounts;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Groups [accounts=" + accounts + ", groupId=" + groupId + ", groupName=" + groupName + "]";
    }
    
}