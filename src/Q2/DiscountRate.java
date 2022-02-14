package Q2;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class DiscountRate {
    // Static variables
    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold = 0.15;
    private static double serviceDiscountSilver = 0.1;
    private static double productDiscountPremium = 0.1;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSilver = 0.1;
    
    /**
     * Determines service discount rate based on type of membership
     * @param type type of membership
     * @return corresponding service discount rate
     */
    public static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0;
        }
    }
    
    /**
     * Determines product discount rate based on type of membership
     * @param type type of membership
     * @return corresponding product discount rate
     */
    public static double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return productDiscountPremium;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                return 0.1;
        }
    }
}
