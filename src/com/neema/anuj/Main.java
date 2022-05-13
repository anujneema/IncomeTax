package com.neema.anuj;

import com.neema.anuj.constants.IncomeTaxRates;
import com.neema.anuj.utils.DataProcessingUtil;
import com.neema.anuj.utils.IOUtil;

import java.util.List;

public class Main {
    public static void main(String gg[]) {
        String[] data = IOUtil.getDummyData();
        List<String[]> processedData = DataProcessingUtil.processInput(data);
        Float total=0f,salesTax=0f,itemSalesTax=0f,itemRate=0f;
        for(String[] item: processedData) {
            itemRate = DataProcessingUtil.getItemRate(item);
            if(DataProcessingUtil.isImported(item)) {
                itemSalesTax += (itemRate * IncomeTaxRates.IMPORT_DUTY)/100f;
            }
            if(!DataProcessingUtil.isExempted(item)) {
                itemSalesTax += (itemRate * IncomeTaxRates.SALES_TAX)/100f;
            }
            itemRate+=itemSalesTax;
            salesTax+=itemSalesTax;
            total+=itemRate;
            itemSalesTax=0f;
            IOUtil.writeOutput(item,itemRate);
        }
        System.out.printf("Sales Taxes:%.2f\n",salesTax);
        System.out.printf("Total:%.2f",total);
    }
}
