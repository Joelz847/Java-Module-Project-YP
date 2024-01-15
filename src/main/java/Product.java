public class Product
{


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
}   //class Product}
