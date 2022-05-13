package com.neema.anuj.utils;

import com.neema.anuj.constants.ExemptedItems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataProcessingUtil {
    public static List<String[]> processInput(String[] data){
        List<String[]> processedData = new LinkedList<>();
        for(String s:data) {
            processedData.add(s.split(" "));
        }
        return processedData;
    }

    public static boolean isImported(String[] data){
        return data[1].equalsIgnoreCase("imported");
    }
    public static Float getItemRate(String[] data){
        return Float.parseFloat(data[data.length-1]);
    }
    public static boolean isExempted(String[] data){
        String itemName =null;
        int sp=0,ep=0,i=0;
        for(String s:data) {
            if(s.equalsIgnoreCase("of")) {
                sp=i+1;
            }
            if(s.equalsIgnoreCase("at"))ep=i-1;
            ++i;
        }
        for(i=sp;i<=ep;i++)itemName+=data[i];
        for(String exmptedItem: ExemptedItems.EXEMPTED_ITEMS_LIST){
            if(itemName.contains(exmptedItem)) {
                return true;
            }
        }
        return false;
    }
}
