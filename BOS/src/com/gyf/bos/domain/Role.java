package com.gyf.bos.domain;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String code;
     private String description;
     private Set users = new HashSet(0);
     private Set functions = new HashSet(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Role(String id, String name, String code, String description, Set users, Set functions) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.users = users;
        this.functions = functions;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getFunctions() {
        return this.functions;
    }
    
    public void setFunctions(Set functions) {
        this.functions = functions;
    }
   








}