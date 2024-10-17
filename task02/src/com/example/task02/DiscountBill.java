package com.example.task02;

public class DiscountBill extends Bill
{
    private final int discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice() - super.getPrice() * discount / 100;
    }

    public String getDiscount() {
        return discount + "%";
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
