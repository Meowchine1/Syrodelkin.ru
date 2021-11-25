
import Pages.MainPage;
import Pages.SignInPage;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.PanelUI;

public class TestCases extends BaseTest {
    private final static String BASE_URL = "https://shop.syrodelkin.ru/";
    private final static String ERROR_MESSAGE = "Неправильный логин или пароль.";
    private final static String WRONG_LOGIN = "Неправильный логин .";
    private final static String WRONG_PASSWORD = "Неправильный пароль.";
    private final static String EXPECTED_CITY = "Екатеринбург";
    private final static String CATEGORY_OF_MENU = "Для колбасы";



    @Test
    public void SignInIsError() {

        SignInPage page = new MainPage(BASE_URL).signIn();
        page.FiilTheFields(WRONG_LOGIN,WRONG_PASSWORD);
        Assert.assertTrue(page.errorMessage().contains(ERROR_MESSAGE));

    }

    @Test
    public void ChangeCity() {
        Assert.assertTrue(new MainPage(BASE_URL).changeLocation(EXPECTED_CITY).contains(EXPECTED_CITY));

    }

    @Test
    public void CheckMenu() {
        MainPage page = new MainPage(BASE_URL);
       Assert.assertTrue(page.Menu(CATEGORY_OF_MENU).SelectSort());

    }


}