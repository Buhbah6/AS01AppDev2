package Q2;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Customer {
    private String name; 
    private boolean member = false;
    private String memberType;

    // CONSTRUCTORS //
    
    public Customer(String name) {
        this.name = name;
        memberType = "non";
    }

    public Customer(String name, boolean member, String memberType) {
        this.name = name;
        this.memberType = memberType;
    }
    
    // GETTERS AND SETTERS //
    
    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    // Overriden toString
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", member=" + member + ", memberType=" + memberType + '}';
    }
}
