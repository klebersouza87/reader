package com.devtech.challenge.service;

import com.devtech.challenge.model.Client;
import com.devtech.challenge.model.Sale;
import com.devtech.challenge.model.Salesman;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Writer {

    static void write(List<Salesman> salesmen, List<Client> clients, List<Sale> sales, String outputFilePath) {
        Charset utf8 = StandardCharsets.UTF_8;
        Path out = Paths.get(outputFilePath);
        System.out.println("Writing File: " + out);

        try (BufferedWriter writer = Files.newBufferedWriter(out, utf8)) {
            writer.write("Number of customers in the input file: " + clients.size() + "\n");
            writer.write("Number of salespeople in the input file: " + salesmen.size() + "\n");
            writer.write("Most expensive sale ID: " + calculateMostExpensiveSaleId(sales) + "\n");
            writer.write("The worst seller: " + findWorstSeller(sales) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculateMostExpensiveSaleId(List<Sale> sales) {
        calcTotalSale(sales);

        Function<Sale, Double> byTotalSale = Sale::getTotalSale;
        Comparator<Sale> totalSale = Comparator.comparing(byTotalSale);

        return sales.stream()
                .max(totalSale)
                .map(Sale::getSaleId).orElse((0));
    }

    private static String findWorstSeller(List<Sale> sales) {
        calcTotalSale(sales);

        Function<Sale, Double> byTotalSale = Sale::getTotalSale;
        Comparator<Sale> totalSale = Comparator.comparing(byTotalSale);

        return sales.stream()
                .min(totalSale)
                .map(Sale::getSalesmanName).orElse("Salesman Not Found");

    }

    private static void calcTotalSale(List<Sale> sales) {

        for (Sale sale: sales) {
            String[] item = sale.getItemIdItemQuantityItemPrice()
                    .replaceAll("[\\[\\]]", "").split(",");

            for (String s : item) {
                String[] values = s.split("-");
                double price = Double.parseDouble(values[1]) * Double.parseDouble(values[2]);
                sale.setTotalSale(price);
            }
        }

    }

}
