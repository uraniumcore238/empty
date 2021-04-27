package tests;

import api.Auth;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTest extends TestBase{

    @Test
    void addItemToCartWithHardCodeTest(){
        Response response =
                given()
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .cookie("Nop.customer=b6901e07-7cc4-4645-841e-ac943ca9c2c3; ARRAffinity=06e3c6706bb7098b5c9133287f2a8d510a64170f97e4ff5fa919999d67a34a46; __utmc=78382081; __utmz=78382081.1618547826.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __utma=78382081.2098670210.1618547826.1618547826.1618807354.2; __atuvc=2%7C15%2C3%7C16; __atuvs=607d0a40f5f6fb3a002; __utmb=78382081.4.10.1618807354")
                    .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
                    .when()
                    .post("/addproducttocart/details/72/1")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("success", is(true))
                    .extract().response();

        System.out.println(response);


    }

    @Test
    void addItemToCartWithCookieTest() {
        Map<String, String> cookies = new Auth().login("qaguru@qa.guru", "qaguru@qa.guru1");

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookies(cookies)
                        .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
                        .when()
                        .post("/addproducttocart/details/72/1")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("success", is(true))
                        .extract().response();

        System.out.println(response);
    }





}
