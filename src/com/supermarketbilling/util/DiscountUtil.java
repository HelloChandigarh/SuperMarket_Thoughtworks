package com.supermarketbilling.util;

import com.supermarketbilling.models.discount.DiscountType;
import com.supermarketbilling.models.item.Item;

import java.math.BigDecimal;

public class DiscountUtil {

    public BigDecimal getDiscountedAmount(Item item , BigDecimal quantity){
        if(item.getDiscount().getDiscountType().equals(DiscountType.PERCENTDISCOUNT)){
            return getPercentageDiscountAmount(item,quantity);
        }else {
            return getFreeItemDiscountAmount(item,quantity);
        }

    }

    double getItemDiscount(Item item){
        return item.getDiscount().getDiscountAmount();
    }

    BigDecimal getPercentageDiscountAmount(Item item,BigDecimal quantity){
        double maxDiscountPercentage= Math.max(getItemDiscount(item),Math.max(item.getParentCategory().getDiscount(),
                item.getParentCategory().getParentCategory().getDiscount()));
        return (item.getPrice().multiply(quantity).multiply(BigDecimal.valueOf( maxDiscountPercentage)))
                .divide(BigDecimal.valueOf(100));
    }

    BigDecimal getFreeItemDiscountAmount(Item item,BigDecimal quantity){
        BigDecimal discount = BigDecimal.valueOf(0);
        while (quantity.intValue() > item.getDiscount().getBuy()) {
            if (quantity.compareTo(BigDecimal.valueOf(item.getDiscount().getBuy() + item.getDiscount().getFree())) > 0 ||
                    quantity.compareTo(BigDecimal.valueOf(item.getDiscount().getBuy() + item.getDiscount().getFree())) == 0) {
                discount = discount.add(BigDecimal.valueOf(item.getDiscount().getFree()).multiply(item.getPrice()));
                quantity = quantity.subtract(BigDecimal.valueOf(item.getDiscount().getBuy() + item.getDiscount().getFree()));
            }
        }
        return discount;
    }

}
