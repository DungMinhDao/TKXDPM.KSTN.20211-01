package businesslogic.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckBarcodeControllerTest {


    @ParameterizedTest
    @CsvSource({
            ",false",
            "34ff23f23f, false",
            "X01,true",
            "123413,false"
    })
    void checkBarcodeAndGetBikeIfTrue(String barcode, Boolean expected) {
        CheckBarcodeController checkBarcodeController = new CheckBarcodeController();
        Boolean isValid = checkBarcodeController.checkBarcodeAndGetBikeIfTrue(barcode).getKey();
        assertEquals(expected, isValid);
    }
}