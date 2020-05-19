/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.stream;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.MoneyUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    private static Gender current = Gender.MALE;

    public static void main(String[] args) {
        Map<Gender, List<Employee>> result = getEmployees().stream()
                .filter(employee -> employee.getSalary() > 150)
                .sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())
                        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(String.valueOf(result));

        float a = 12345678.209f;
        double b = 1234567891234567.555555555555d;

        DecimalFormat df = new DecimalFormat("#.00000000000000");
        BigDecimal c;
        for (int i = 0; i < 10; i++) {
            a += 1;
            b += 1;
            System.out.println(a + "|" + b);

        }

        CurrencyUnit CNY = CurrencyUnit.of("CNY");
        System.out.println(CNY.getDecimalPlaces());

        Money m1 = Money.of(CNY, 100);
        Money m2 = Money.of(CurrencyUnit.USD, 100);

        Money m3 = MoneyUtils.add(m1, m2.convertedTo(CNY, new BigDecimal("6.02"), RoundingMode.HALF_UP));
        m3 = m3.dividedBy(3, RoundingMode.HALF_UP);
        System.out.println(m3.toString());


        Func func = (one, two) -> one > two;

        printFunc(1, 2, func);

    }


    private static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            employees.add(new Employee(20 + i % 20, i + 100, nextGender()));
        }
        return employees;
    }

    private static Gender nextGender() {
        current = current.equals(Gender.MALE) ? Gender.FEMALE : Gender.MALE;
        return current;
    }

    private static void printFunc(int a, int b, Func func) {
        System.out.println(func.compare(a, b));
    }


    private enum Gender {
        MALE, FEMALE;
    }

    @FunctionalInterface
    private static interface Func {
        boolean compare(int a, int b);
    }

    private static class Employee {
        private int salary;
        private Gender gender;
        private int age;

        public Employee(int age, int salary, Gender gender) {
            this.age = age;
            this.salary = salary;
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }


    }
}
