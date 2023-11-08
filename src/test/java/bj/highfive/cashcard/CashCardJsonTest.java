package bj.highfive.cashcard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.json.JacksonTester;

public class CashCardJsonTest {
   /*  @Test // marque le fonction ci-dessous comme étant un test
    public void myFirstTest() {
        //assertEquals vérifie l'égalité.
        assertEquals(2, 2);
    }*/

    @Autowired
    private JacksonTester<CashCard> json;

    //Test unitaire
    @Test 
    public void cashCardSerializationTest()  throws 
    IOException{
        CashCard cashcard = new CashCard(99L, 123.45);
        assertThat(json.write(cashcard)).isStrictlyEqualToJson("expected.json");
        assertEquals(json.write(cashcard)).hasJsonPathNumberValue("@.id");//Vérification de la présence de la propriété id
        assertThat(json.write(cashcard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertEquals(json.write(cashcard)).hasJsonPathNumberValue("@.amount");//Vérification de la présence de la propriété amount
        assertThat(json.write(cashcard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.);
        

    }   

    }

}
