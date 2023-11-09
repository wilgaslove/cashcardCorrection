package bj.highfive.cashcard;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.json.JacksonTester;
import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
public class CashCardJsonTest {
    /*
     * @Test // marque le fonction ci-dessous comme étant un test
     * public void myFirstTest() {
     * //assertEquals vérifie l'égalité.
     * assertEquals(2, 2);
     * }
     */

    @Autowired
    private JacksonTester<CashCard> json;

    // Test unitaire
    @Test
    public void cashCardSerializationTest() throws IOException {
        CashCard cashcard = new CashCard(99L, 123.45);
        assertThat(json.write(cashcard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashcard)).hasJsonPathNumberValue("@.id");// Vérification de la présence de la propriété
                                                                        // id
        assertThat(json.write(cashcard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(json.write(cashcard)).hasJsonPathNumberValue("@.amount");// Vérification de la présence de la
                                                                            // propriété amount
        assertThat(json.write(cashcard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);

    }

    @Test 
    public void cashCardDeserializationTest() throws IOException {
        String expected = """
        {
            "id": 99,
            "amount":123.45
        }
        """;
        assertThat(json.parse(expected)).isEqualTo( new CashCard(99L, 123.45));
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }



}
