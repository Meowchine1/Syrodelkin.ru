package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement linkPersonalRoom = $x("//a[@title='Личный кабинет']");
    private final SelenideElement linkSignIn = $x("//a[text()='Авторизация']");
    private final SelenideElement linkSignUp = $x("//a[text()='Регистрация']");
    private final SelenideElement currentLocation = $x("//a[@class='prmn-cmngr__city']");
    private final ElementsCollection categoryCollection = $$x("//ul[@class='nav navbar-nav dblock_zadergka']//i");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public SignInPage signIn(){
        linkPersonalRoom.click();
        linkSignIn.click();
        return new SignInPage();

    }

   public String changeLocation(String cityName) {
       currentLocation.click();
        SelenideElement newCity = $x("//*[contains(text(),'" + cityName + "')]").shouldBe(Condition.visible);
        newCity.click();
        return currentLocation.shouldBe(Condition.text(cityName)).getText();
   }

   public CategoryPage Menu(String category) {
        for(var elem : categoryCollection) {
            if(elem.getText().equals(category)) {
                $x("//ul[@class='nav navbar-nav dblock_zadergka']//a").click();
                break;
            }

        }
        return new CategoryPage();



   }




}
