package com.sourav.rma.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privilege {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_sequence")
//    @SequenceGenerator(sequenceName = "privilege_sequence", name = "privilege_sequence")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Collection<Role> roles;

	public Privilege() {
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
 
}
