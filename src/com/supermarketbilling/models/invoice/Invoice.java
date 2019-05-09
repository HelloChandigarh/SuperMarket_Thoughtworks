package com.supermarketbilling.models.invoice;

import com.supermarketbilling.util.InvoiceUtil;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {

    private List<IndividualItemInvoice> itemInvoices;
    private String customerName;
    private BigDecimal totalInvoiceAmount;
    private BigDecimal totalInvoiceDiscountAmount;
    private InvoiceUtil invoiceUtil=new InvoiceUtil();

    public Invoice(List<IndividualItemInvoice> itemInvoices, String customerName) {
        this.itemInvoices = itemInvoices;
        this.customerName = customerName;
        this.totalInvoiceAmount=invoiceUtil.getTotalInvoiceAmount(itemInvoices);
        this.totalInvoiceDiscountAmount=invoiceUtil.getTotalInvoiceDiscountAmount(itemInvoices);
    }

    public List<IndividualItemInvoice> getItemInvoices() {
        return itemInvoices;
    }

    public void setItemInvoices(List<IndividualItemInvoice> itemInvoices) {
        this.itemInvoices = itemInvoices;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalInvoiceAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return totalInvoiceDiscountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.totalInvoiceDiscountAmount = discountAmount;
    }
}
