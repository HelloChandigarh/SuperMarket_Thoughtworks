package com.supermarketbilling.util;

import com.supermarketbilling.models.invoice.IndividualItemInvoice;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceUtil {


    public BigDecimal getTotalInvoiceAmount(List<IndividualItemInvoice> itemInvoices){
        return BigDecimal.valueOf(itemInvoices.stream().mapToDouble(i-> {
                    return i.getTotalAmount().doubleValue();
                }
        ).sum());
    }

    public BigDecimal getTotalInvoiceDiscountAmount(List<IndividualItemInvoice> itemInvoices){
        return BigDecimal.valueOf(itemInvoices.stream().mapToDouble(i-> {
                    return i.getDiscountAmount().doubleValue();
                }
        ).sum());
    }
}
