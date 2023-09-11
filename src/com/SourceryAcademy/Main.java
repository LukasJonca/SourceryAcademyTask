package com.SourceryAcademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Main {
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        IntStream.rangeClosed(fromYear, toYear).forEach(year ->
                IntStream.rangeClosed(1, 12).forEach(month ->
                        IntStream.rangeClosed(1, 31).forEach(day -> {
                            if (isValidDate(year, month, day)) {
                                String dateStr = formatter.format(LocalDate.of(year, month, day));
                                String reversedDateStr = new StringBuilder(dateStr).reverse().toString();

                                if (dateStr.equals(reversedDateStr)) {
                                    System.out.println(String.format("%d-%02d-%02d", year, month, day));
                                }
                            }
                        })
                )
        );
    }

    private static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}
