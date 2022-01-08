package businesslogic.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckCardInUseControllerTest {

    @BeforeEach
    void setUp() {

    }
    @ParameterizedTest
    @CsvSource({
            "kstn_group1_2021, true",
            "kstn_group2_2021, false"
    })

    void checkCardInUse(String cardCode, Boolean expected) {
        CheckCardInUseController checkCardInUseController = new CheckCardInUseController();
        Boolean check = checkCardInUseController.checkCardInUse(cardCode);
        assertEquals(expected, check);
    }


}