package com.sourav.rma.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
//    @SequenceGenerator(sequenceName = "role_sequence", name = "role_sequence")
    private Long id;

    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany(cascade = {/*CascadeType.PERSIST,*/CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "roles_privileges", 
      		   joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
      		   inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    /**
     * JPA
     */
	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
    
}
