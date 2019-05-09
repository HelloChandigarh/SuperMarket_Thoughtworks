package com.supermarketbilling;

import com.supermarketbilling.models.Category.Category;
import com.supermarketbilling.models.discount.Discount;
import com.supermarketbilling.models.discount.DiscountType;
import com.supermarketbilling.models.invoice.IndividualItemInvoice;
import com.supermarketbilling.models.invoice.Invoice;
import com.supermarketbilling.models.item.Item;
import com.supermarketbilling.models.item.UOM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceMaker {

    static Map<String, Item> items;

    public static void initData(){

        items=new HashMap<>();

                                Category produce=new Category();
                                produce.setName("produce");
                                produce.setDiscount(10);

        Category fruits=new Category();
        fruits.setName("Fruits");
        fruits.setParentCategory(produce);
        fruits.setDiscount(18);

                                                    Category veg=new Category();
                                                    veg.setName("Veg");
                                                    veg.setParentCategory(produce);
                                                    veg.setDiscount(5);

        Item apple=new Item();
        apple.setName("Apple");
        apple.setParentCategory(fruits);
        apple.setPrice(BigDecimal.valueOf(50));
        apple.setUom(UOM.KILO);
        apple.setDiscount(new Discount(DiscountType.FREEITEMDISCOUNT,0,3,1));

        Item orange=new Item();
        orange.setName("Orange");
        orange.setParentCategory(fruits);
        orange.setPrice(BigDecimal.valueOf(80));
        orange.setUom(UOM.KILO);
        orange.setDiscount(new Discount(DiscountType.PERCENTDISCOUNT,20,0,0));


                                                        Item potato=new Item();
                                                        potato.setName("Potato");
                                                        potato.setParentCategory(veg);
                                                        potato.setPrice(BigDecimal.valueOf(30));
                                                        potato.setUom(UOM.KILO);
                                                        potato.setDiscount(new Discount(DiscountType.FREEITEMDISCOUNT,0  ,5,2));

                                                        Item tomato=new Item();
                                                        tomato.setName("Tomato");
                                                        tomato.setParentCategory(veg);
                                                        tomato.setPrice(BigDecimal.valueOf(70));
                                                        tomato.setUom(UOM.KILO);
                                                        tomato.setDiscount(new Discount(DiscountType.PERCENTDISCOUNT,10,0,0));

                            Category dairy=new Category();
                            dairy.setName("Dairy");
                            dairy.setDiscount(15);


        Category milk=new Category();
        milk.setName("Milk");
        milk.setParentCategory(dairy);
        milk.setDiscount(20);

                                                        Category cheese=new Category();
                                                        cheese.setName("Cheese");
                                                        cheese.setParentCategory(dairy);
                                                        cheese.setDiscount(20);


        Item cowMilk=new Item();
        cowMilk.setName("Cow Milk");
        cowMilk.setParentCategory(milk);
        cowMilk.setPrice(BigDecimal.valueOf(50));
        cowMilk.setUom(UOM.LITRE);
        cowMilk.setDiscount(new Discount(DiscountType.FREEITEMDISCOUNT,0,3,1));

        Item soyMilk=new Item();
        soyMilk.setName("Soy Milk");
        soyMilk.setParentCategory(milk);
        soyMilk.setPrice(BigDecimal.valueOf(40));
        soyMilk.setUom(UOM.LITRE);
        soyMilk.setDiscount(new Discount(DiscountType.PERCENTDISCOUNT,10,0,0));



                                                            Item cheddar=new Item();
                                                            cheddar.setName("Cheddar");
                                                            cheddar.setParentCategory(cheese);
                                                            cheddar.setPrice(BigDecimal.valueOf(50));
                                                            cheddar.setUom(UOM.KILO);
                                                            cheddar.setDiscount(new Discount(DiscountType.FREEITEMDISCOUNT,0,2,1));


                                                            Item gouda=new Item();
                                                            gouda.setName("Gouda");
                                                            gouda.setParentCategory(cheese);
                                                            gouda.setPrice(BigDecimal.valueOf(80));
                                                            gouda.setUom(UOM.KILO);
                                                            gouda.setDiscount(new Discount(DiscountType.PERCENTDISCOUNT,10,0,0));



        items.put("apple",apple);
        items.put("orange",orange);
        items.put("potato",potato);
        items.put("tomato",tomato);
        items.put("cowmilk",cowMilk);
        items.put("soymilk",soyMilk);
        items.put("cheddar",cheddar);
        items.put("gouda",gouda);

    }

    public static void main(String... args){
        initData();

        IndividualItemInvoice appleInvoice=new IndividualItemInvoice(items.get("apple"),BigDecimal.valueOf(6));
        IndividualItemInvoice orangeInvoice=new IndividualItemInvoice(items.get("orange"),BigDecimal.valueOf(2));
        IndividualItemInvoice potatoInvoice=new IndividualItemInvoice(items.get("potato"),BigDecimal.valueOf(14));
        IndividualItemInvoice tomatoInvoice=new IndividualItemInvoice(items.get("tomato"),BigDecimal.valueOf(3));
        IndividualItemInvoice cowMilkInvoice=new IndividualItemInvoice(items.get("cowmilk"),BigDecimal.valueOf(8));
        IndividualItemInvoice goudaInvoice=new IndividualItemInvoice(items.get("gouda"),BigDecimal.valueOf(2));

        List<IndividualItemInvoice> individualItemInvoices=new ArrayList<>();
        individualItemInvoices.add(appleInvoice);
        individualItemInvoices.add(orangeInvoice);
        individualItemInvoices.add(potatoInvoice);
        individualItemInvoices.add(tomatoInvoice);
        individualItemInvoices.add(cowMilkInvoice);
        individualItemInvoices.add(goudaInvoice);

        Invoice invoice=new Invoice(individualItemInvoices,"Sahil");

        System.out.println("Customer Name:"+invoice.getCustomerName());
        System.out.format("%32s%10s%16s\n", "Item", "Qty","Amount");
        individualItemInvoices.stream().forEach(individualItemInvoice->{
            System.out.format("%32s%10s%16s\n",individualItemInvoice.getItem().getName().toString(),
                    individualItemInvoice.getQuantity(),individualItemInvoice.getTotalAmount().toString());
        });
        System.out.println("----------------------------------------------------------------------------------");
        System.out.format("Total Amount"+"%45s\n",invoice.getTotalAmount());
        System.out.format("You Saved"+"%48s\n",invoice.getDiscountAmount());

    }
}
