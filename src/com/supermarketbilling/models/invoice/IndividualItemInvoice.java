package com.supermarketbilling.models.invoice;

import com.supermarketbilling.models.item.Item;
import com.supermarketbilling.util.DiscountUtil;

import java.math.BigDecimal;

public class IndividualItemInvoice {
    private Item item;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private BigDecimal discountAmount;
    private DiscountUtil discountUtil=new DiscountUtil();

    public IndividualItemInvoice(Item item, BigDecimal quantity) {
        this.item = item;
        this.quantity = quantity;
        this.discountAmount=discountUtil.getDiscountedAmount(item,quantity);
        this.totalAmount=(item.getPrice().multiply(quantity)).subtract(this.discountAmount);

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
}
