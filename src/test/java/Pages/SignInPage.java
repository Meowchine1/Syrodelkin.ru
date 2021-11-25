package Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class SignInPage {
    private final SelenideElement textBoxLogin = $x("//input[@name = 'email']");
    private final SelenideElement textBoxPassword = $x("//input[@name = 'password']");
    private final SelenideElement textErrorMessage = $x("//div[text()='Неправильный логин или пароль.']");

    public void FiilTheFields(String login, String password){
        textBoxLogin.setValue(login);
        textBoxPassword.setValue(password);
        textBoxPassword.sendKeys(Keys.ENTER);
    }

    public String errorMessage(){
        textErrorMessage.shouldBe(visible);
        return textErrorMessage.getText();

    }

}

