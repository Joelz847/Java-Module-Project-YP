


import java.util.Scanner;



class Product
{
    String name= "";
    String listName = "";
    float price = 2f;
    float amountPrice = 2f;
}

public class Main {
    public static String rubl (float summ)
    {
        String rub = "рубл";
        int money = (int) summ;

        if (money % 100 >= 11 && money%100 <= 14){
            return "ей";
        } else {
        switch (money) {
            case 1:
                rub= rub+ "ь";
            case 2, 3, 4:
                rub= rub+ "я";
            default:
                rub= rub+ "ей";
        }
        }
        return rub;
    }

    public static void main(String[] args) {


        int members;

        double totalAmount;

        Scanner scanner = new Scanner(System.in);

    Product productList = new Product();

        System.out.println("Hello world!");

        while (true) {
            System.out.println("\n" + "На скольких человек необходимо разделить счёт?");

            try {
                members = scanner.nextInt();// Запрос числа покупателей
            }  catch (Exception e) {
                System.out.println("Нужна цифра");
              members = 0;
             //break;
             System.exit(0);
             }

            switch (members) {
                case 0:
                    System.out.println("Не корректное значение");
                    break;
                case 1:
                    System.out.println("Нет смысла ничего считать и делить.");
                    break;
                default:
                    {
                    System.out.println("Пришло " + members + " человека.");
                    break;
                    }

            }
            if (members <=0)
            System.out.println("Не корректное значение");
            if (members >1)
                break;
        }

        // Получение товаров
        while (true) {

          System.out.println("Название товара");

            var input = scanner.next();

            if (input.equalsIgnoreCase("завершить")) {
                break;}

            System.out.println(productList.name);

            System.out.println("Сколько стоит товар");

            productList.price = scanner.nextFloat();
            if (productList.price <= 0) {
                System.out.println("Цена должна быть положительной!");
                break;
            }
            productList.listName += input + "\n";
            productList.amountPrice += productList.price;


        }
        System.out.println("Добавленные товары:\n");
        System.out.println(productList.listName);
        System.out.println("Сумма на каждого покупателя = " + productList.amountPrice/members + " " + rubl(productList.amountPrice/members) );
    }
}