import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestAssertion {

    @Test
    @Tag("positive")
    @DisplayName("Positive summation test")
    void SummationTest(){
        int summation = 1+1;
        step("Assert that 1+1=2", () ->
        assertThat(summation, equalTo(2)));

  }

    @Test
    @Tag("negative")
    @DisplayName("Negative summation test")
    void SummationTestNegative(){
        int summation = 1+1;
        step("Assert that 1+1=3", () ->
        assertThat(summation, equalTo(3)));

    }


    @Test
    @Tag("positive")
    @DisplayName("Positive multiplication test")
    void MultiplicationTest(){
        int multiplication = 2*2;
        assertThat(multiplication, equalTo(4));

    }

    @Test
    @Tag("negative")
    @DisplayName("Negative multiplication test")
    void MultiplicationTestNegative(){
        int multiplication = 2*2;
        assertThat(multiplication, equalTo(5));

    }

    @Test
    @Tag("positive")
    @DisplayName("Positive division test")
    void DivisionTest(){
        int div = 2/2;
        assertThat(div, equalTo(1));

    }

    @Test
    @Tag("negative")
    @DisplayName("Negative division test")
    void DivisionTestNegative(){
        int div = 2/2;
        assertThat(div, equalTo(3));

    }
}