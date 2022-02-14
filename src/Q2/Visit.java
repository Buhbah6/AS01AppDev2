package Q2;

import java.util.Date;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Visit {
    // Instance Variables
    protected Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    // CONSTRUCTORS //
    
    public Visit(String name, Date date) {
        this.customer = new Customer(name);
        this.date = date;
    }

    public Visit(Customer customer, double serviceExpense, double productExpense) {
        this.customer = customer;
        this.date = new Date();
        this.serviceExpense = serviceExpense;
        this.productExpense = productExpense;
    }

    // GETTERS AND SETTERS //
    
    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    
    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    // Overriden toString
    @Override
    public String toString() {
        return "Visit{" + "customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense + ", productExpense=" + productExpense + '}';
    }
}
