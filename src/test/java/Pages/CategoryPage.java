package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage {
    private final ElementsCollection selectSort = $$x("//select[@id='input-sort']//option");
    private final ElementsCollection productCollection = $$x("//div[@class='row products_category']//div[@class='price']");

    public CategoryPage(){}

    public boolean SelectSort() {

       String sort = "Цена (низкая > высокая)";
       for( var elem : selectSort) {
           if(elem.getText().equals(sort)) {
               elem.setSelected(true);
           }
       }
       String preSum = productCollection.first().getText();
       String actualSum;
       for(var elem : productCollection) {
           actualSum = elem.getText();
           if(Integer.parseInt(preSum.split("")[0]) > Integer.parseInt(actualSum.split("")[0])) {
               return false;
           }

       }
       return true;
    }

}
