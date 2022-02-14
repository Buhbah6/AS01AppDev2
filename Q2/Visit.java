package Q2;

import java.util.Date;

/**
 * @author Anthony Nadeau
 */
public class Visit {
   protected Customer customer;
   private Date date;
   private double serviceExpense;
   private double productExpense;

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

    @Override
    public String toString() {
        return "Visit{" + "customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense + ", productExpense=" + productExpense + '}';
    }
}
