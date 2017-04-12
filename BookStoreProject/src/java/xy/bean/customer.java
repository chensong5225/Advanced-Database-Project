/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.bean;

import java.io.Serializable;

/**
 *
 * @author mac
 */


public class customer extends Object implements Serializable{
    
    public static final String ISTATUS = "Login";
    
    private String id;
    private String password;
    private String email;
    private String name;
    private String addressid;
    private String gender;
    private String marriage_status;
    private int age;
    private long income;
    private String category;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addressid
     */
    public String getAddressid() {
        return addressid;
    }

    /**
     * @param addressid the addressid to set
     */
    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the marriage_status
     */
    public String getMarriage_status() {
        return marriage_status;
    }

    /**
     * @param marriage_status the marriage_status to set
     */
    public void setMarriage_status(String marriage_status) {
        this.marriage_status = marriage_status;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the income
     */
    public long getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(long income) {
        this.income = income;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
