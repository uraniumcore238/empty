package tests;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

public class LoginTest extends TestBase {

    @Test
    void loginWithUiTest() {
        // authorize
        // qaguru@qa.guru qaguru@qa.guru1
        open("/login");
        $("#Email").val("qaguru@qa.guru");
        $("#Password").val("qaguru@qa.guru1").pressEnter();

        // verify successful authorization
        $(".account").shouldHave(text("qaguru@qa.guru"));
    }


    @Test
    void loginWitCookieTest() {
        // authorize
        // qaguru@qa.guru qaguru@qa.guru1
        Map<String, String> cookiesMap =
                given()
//                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .contentType(ContentType.URLENC)
//                        .cookie("ARRAffinity=06e3c6706bb7098b5c9133287f2a8d510a64170f97e4ff5fa919999d67a34a46; __utma=78382081.1134972585.1619411002.1619411002.1619411002.1; __utmc=78382081; __utmz=78382081.1619411002.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ASP.NET_SessionId=q2gm45nb5lhu5gwkbhxg5pf2; Nop.customer=b383990e-6f09-4d18-9569-c83e0e6b6682; __utmt=1; __utmb=78382081.5.10.1619411002")
                        .formParam("Email", "qaguru@qa.guru")
                        .formParam("Password", "qaguru@qa.guru1")
//                        .formParam("RememberMe", "false")
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .log().body()
//                        .body("success", is(true))
                        .extract().cookies();

        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/top-menu-divider.png");

        getWebDriver().manage().addCookie(new Cookie("Nop.customer", cookiesMap.get("Nop.customer")));
        getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", cookiesMap.get("NOPCOMMERCE.AUTH")));
        getWebDriver().manage().addCookie(new Cookie("ARRAffinity", cookiesMap.get("ARRAffinity")));


        open("");
        $(".account").shouldHave(text("qaguru@qa.guru"));
    }


}
