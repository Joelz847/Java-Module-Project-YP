


import java.util.Scanner;

class Product {

    String name = "";

    String listName = "";

    float price;

    float amountPrice;


    public static String formRubl(float summ) {

        String rub = String.format("%.2f", summ) + " рубл"; //число с дробью .00 + рубл


        int money = (int) summ;


        if (money % 100 >= 5 && money % 100 <= 20) {

            return rub + "ей";

        } else {

            switch (money % 10) {

                case 1:

                    rub = rub + "ь";

                    break;

                case 2, 3, 4:

                    rub = rub + "я";

                    break;

                default:

                    rub = rub + "ей";

                    break;

            }

        }

        return rub;

    }

} //class Product

public class Main {


    public static void main(String[] args) {


        //-----------------------


        int members;


        Scanner scanner = new Scanner(System.in);


        Product productList = new Product();


        System.out.println("Hello world!");


        while (true) {


            System.out.println("На скольких человек необходимо разделить счёт? ");


            if (scanner.hasNextInt()) {

                members = scanner.nextInt();

            } else {

                members = 0; //обязательная инициализация для компилятора


                String tmp = scanner.nextLine(); // scanner.nextInt() нельзя выдаст ошибку, т.к. введён не int

                System.out.println("Вы ввели не целое число");

            }


            switch (members) {

                case 0:

                    System.out.println("Не корректное значение");

                    break;

                case 1:

                    System.out.println("Нет смысла ничего считать и делить.");

                    break;

            }


            if (members < 0) {

                System.out.println("Не корректное значение");

            }


            if (members > 1) {

                System.out.println("Пришло " + members + " человека.");

                break;

            }

        }


// Получение товаров


        productList.amountPrice = 0;

        productList.name = "";


        while (true) {


            System.out.print("\nВведите название товара: ");


            var input = scanner.next();


            System.out.print("Сколько стоит товар: ");


            if (scanner.hasNextInt()) {

                productList.price = scanner.nextFloat();


                if (productList.price <= 0) {

                    System.out.println("Цена должна быть положительной!");

                    break;

                }


            } else {

                productList.price = 0; //обязательная инициализация для компилятора


                String tmp = scanner.nextLine(); // scanner.nextInt() нельзя выдаст ошибку, т.к. введён не int

                System.out.println("Вы ввели не целое число");

            }


            productList.listName += input;

            productList.listName = productList.listName + "=" + String.format("%.2f", productList.price) + "р.\n";


            productList.amountPrice += productList.price;


//System.out.println("Сумма товаров= " + productList.amountPrice);


            System.out.println("Завершить ввод?");

            System.out.print("да/нет или 'завершить': ");


// input = scanner.next();


            if ((scanner.nextLine().isEmpty())) {

                input = scanner.nextLine();

                System.out.println("продолжаем..."); //реакция на ввод пустой строки


            } else input = scanner.next();


            System.out.println("input= " + input);


            if (input.equalsIgnoreCase("да") || input.equalsIgnoreCase("завершить")) {

                break;

            }


        }


        System.out.println("\nДобавленные товары:");

        System.out.print(productList.listName);

        System.out.print("Сумма на каждого покупателя = ");


        System.out.println(Product.formRubl(productList.amountPrice / members));

    }

}