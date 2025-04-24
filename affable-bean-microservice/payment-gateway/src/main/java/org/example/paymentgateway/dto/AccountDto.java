package org.example.paymentgateway.dto;



public class AccountDto {
    private int id;
    private String cardNumber;
    private String name;
    private double amount;

    public AccountDto() {}

    public AccountDto(int id, String cardNumber, String name, double amount) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
