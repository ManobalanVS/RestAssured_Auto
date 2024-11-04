package GoogleMaps;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Nested_Complex_Json {

    public static void main(String[] args) {
        // Testing using the dummy API, while the real one is under dev stage
        JsonPath js = new JsonPath(Payload.Courseprice());

        // Print No of courses returned by API
        int TotalCourse = js.getInt("courses.size()");
        System.out.println("Total No.of Courses:"+TotalCourse);

        // Print Purchase Amount
        int purAmnt = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase amnt:"+purAmnt);

        // Print Title of the courses
        String Firstcoursetitle = js.get("courses[0].title");
        System.out.println("First course title:"+Firstcoursetitle);

        String Seccoursetitle = js.get("courses[1].title");
        System.out.println("Second course title:"+Seccoursetitle);

        String Thirdcoursetitle = js.get("courses[2].title");
        System.out.println("Third course title:"+Thirdcoursetitle);
        System.out.println("---------------XXX----------------");

        // Print All course titles and their respective Prices - Dynamic
        for(int i=0;i<TotalCourse;i++){
           String courseTitles = js.get("courses["+i+"].title");
           System.out.println(courseTitles);

           int coursePrice = js.get("courses["+i+"].price");
           System.out.println(coursePrice);
        }

        // Print no of copies sold by RPA Course
        for(int i=0;i<TotalCourse;i++) {
            String courseTitles = js.get("courses["+i+"].title");
            if (courseTitles.equalsIgnoreCase("RPA")){
               int copies = js.get("courses["+i+"].copies");
                System.out.println("No.of copies sold: "+copies);
                break;
            }
        }

    }

}
