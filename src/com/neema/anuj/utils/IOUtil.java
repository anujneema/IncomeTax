package com.neema.anuj.utils;

import java.util.Scanner;

public class IOUtil {
    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        return data;
    }
    public static String[] getDummyData() {
        String[] data = {
            "1 imported bottle of perfume at 27.99",
            "1 bottle of perfume at 18.99",
            "1 packet of headache pills at 9.75",
            "1 imported box of chocolates at 11.25"
        };
        return data;
    }

    public static void writeOutput(String[] data,Float itemRate) {
        for(int i=0;i<data.length-1;++i) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
        System.out.printf("%.2f\n",itemRate);
    }
}
