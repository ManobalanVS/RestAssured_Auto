package GoogleMaps;

import Files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Nested_SumValidation {

    @Test
    public void sumOfCourses(){
        // Testing using the dummy API, while the real one is under dev stage
        JsonPath js = new JsonPath(Payload.Courseprice());

        // Verify if Sum of all Course prices matches with Purchase Amount
        int Totalcourses = js.getInt("courses.size()");
        int sum = 0;
        for(int i=0;i<Totalcourses;i++){
            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");

            int amount = price*copies;
            System.out.println(amount);

            sum = sum + amount;
        }
        System.out.println(sum);

        int purchaseAmnt = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchaseAmnt);
    }
}
