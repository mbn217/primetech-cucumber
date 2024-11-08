package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utilities.DBUtils;

public class AddItem_And_Veirfy_DB_StepDef {
    @And("the item is added into the DB")
    public void the_item_is_added_into_the_db() {
        String query = "select * from CraterDBS.items order by created_at desc;";
        String name = DBUtils.selectRecord(query,"name");
        System.out.println("THe new item name is : " + name);
        Assert.assertTrue(!name.isEmpty());
    }

}
