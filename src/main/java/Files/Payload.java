package Files;

public class Payload {


    public static String addPlace(){
        return "{\n" +
                "    \"location\": {\n" +
                "        \"latitude\": \"-38.383494\",\n" +
                "        \"longitude\": \"33.427362\"\n" +
                "    },\n" +
                "    \"accuracy\": \"50\",\n" +
                "    \"name\": \"Mano house\",\n" +
                "    \"phone_number\": \"(+91) 9080908090\",\n" +
                "    \"address\": \"29, side layout, cohen 09\",\n" +
                "    \"types\": \"shoe park,shop\",\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String Courseprice(){
        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 2350,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 20\n" +
                "},{\n" +
                "\"title\": \"Appium\",\n" +
                "\"price\": 90,\n" +
                "\"copies\": 11\n" +
                "}\n" +
                "]\n" +
                "}\n";
    }
}
