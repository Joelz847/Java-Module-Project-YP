


import java.util.Scanner;



public class Main {


    public static void main(String[] args) {


        //-----------------------


        int members;


        Scanner scanner = new Scanner(System.in);


        Product productList = new Product();


        //  System.out.println("Hello world!");


        while (true) {


            System.out.println("На скольких человек необходимо разделить счёт? ");


            if (scanner.hasNextInt()) {

                members = scanner.nextInt();

            } else {

                members = 0; //обязательная инициализация для компилятора


                String tmp = scanner.nextLine(); // сброс неверного значения, scanner.nextInt() нельзя выдаст ошибку, т.к. введён не int

                System.out.println("Вы ввели не целое число");

            }


            if (members <= 0) {

                System.out.println("Не корректное значение");

            }
            else if (members == 1)
            {
                System.out.println("Нет смысла ничего считать и делить.");

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

                    productList.price = 0; //обязательная инициализация для компилятор

                    // break;

                }


            } else {

                productList.price = 0; //обязательная инициализация для компилятора


                String tmp = scanner.next(); // scanner.nextInt() нельзя выдаст ошибку, т.к. введён не int

                System.out.println("Вы ввели не целое число");

//                break;
            }

            if (productList.price != 0) {

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

        }


        System.out.println("\nДобавленные товары:");

        System.out.print(productList.listName);

        System.out.print("Сумма на каждого покупателя = ");


        System.out.println(Product.formRubl(productList.amountPrice / members));

    }

}