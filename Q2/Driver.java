package Q2;


/**
 * @author Anthony Nadeau
 */
public class Driver {
    
    public static void main(String[] args) {
        Customer[] customers = {new Customer("Leonard", true, "Premium"),
        new Customer("John", true, "Gold"), new Customer("Lina", true, "Silver"),
        new Customer("Jeremy")};
        
        Visit[] visits = {new Visit(customers[0], 74.99, 372.9), new Visit(customers[1], 74.99, 372.9),
        new Visit(customers[2], 74.99, 372.9), new Visit(customers[3], 74.99, 372.9)};
        
        for (Visit vis : visits) {
            System.out.println(String.format(
                "Customer %s spent $%.2f in services, and $%.2f in products for a subtotal of %.2f.\n"
                        + "As a %s member, they got a total discount of $%.2f services, and $%.2f in products.\n"
                        + "Their total came out to $%.2f.\n", vis.customer.getName(), vis.getServiceExpense(),
                        vis.getProductExpense(), vis.getTotalExpense(), vis.customer.getMemberType(),
                        calcServiceRebate(vis), calcProductRebate(vis), calcFinalCost(vis)));
        }
        System.out.println("That concludes our sales report.");
    }
    
    public static double calcServiceRebate(Visit vis) {
        return DiscountRate.getServiceDiscountRate(vis.customer.getMemberType()) * 
            vis.getServiceExpense();
    }
    
    public static double calcProductRebate(Visit vis) {
        return DiscountRate.getProductDiscountRate(vis.customer.getMemberType()) *
            vis.getProductExpense();
    }
    
    public static double calcFinalCost(Visit vis) {          
        return (vis.getProductExpense() - calcProductRebate(vis)) + 
                (vis.getServiceExpense() - calcServiceRebate(vis));
    }
}
