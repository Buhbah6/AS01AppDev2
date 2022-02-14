package Q2;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Driver {
    
    /**
     * Main Method -> provides test case for below methods.
     * @param args 
     */
    public static void main(String[] args) {
        // Creating and storing customers in an array
        Customer[] customers = {new Customer("Leonard", true, "Premium"),
        new Customer("John", true, "Gold"), new Customer("Lina", true, "Silver"),
        new Customer("Jeremy")};
        
        // Using customer array to create and store visits in an array
        Visit[] visits = {new Visit(customers[0], 74.99, 372.9), new Visit(customers[1], 74.99, 372.9),
        new Visit(customers[2], 74.99, 372.9), new Visit(customers[3], 74.99, 372.9)};
        
        // for each to print out resume of visits using methods below
        for (Visit vis : visits) {
            System.out.println(String.format(
                "Customer %s spent $%.2f in services, and $%.2f in products for a subtotal of %.2f.\n"
                        + "As a %s member, they got a total discount of $%.2f services, and $%.2f in products.\n"
                        + "Their total came out to $%.2f.\n", vis.customer.getName(), vis.getServiceExpense(),
                        vis.getProductExpense(), vis.getTotalExpense(), vis.customer.getMemberType(),
                        calcServiceRebate(vis), calcProductRebate(vis), calcFinalCost(vis)));
        }
        // End message
        System.out.println("That concludes our sales report.");
    }
    
    /**
     * Calculates the amount discounted from the service expense of the visit
     * @param vis the visit providing the service expense
     * @return the amount discounted from the service expense of the visit
     */
    public static double calcServiceRebate(Visit vis) {
        return DiscountRate.getServiceDiscountRate(vis.customer.getMemberType()) * 
            vis.getServiceExpense();
    }
    
    /**
     * Calculates the amount discounted from the product expense of the visit
     * @param vis the visit providing the product expense
     * @return the amount discounted from the product expense of the visit
     */
    public static double calcProductRebate(Visit vis) {
        return DiscountRate.getProductDiscountRate(vis.customer.getMemberType()) *
            vis.getProductExpense();
    }
    
    /**
     * Calculates the total cost of a visit excluding the discounts
     * @param vis the visit providing the service and product expenses
     * @return the total cost of a visit excluding the discounts
     */
    public static double calcFinalCost(Visit vis) {          
        return (vis.getProductExpense() - calcProductRebate(vis)) + 
                (vis.getServiceExpense() - calcServiceRebate(vis));
    }
}
