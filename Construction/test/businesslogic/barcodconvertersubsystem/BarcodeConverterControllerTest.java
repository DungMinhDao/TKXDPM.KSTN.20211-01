package businesslogic.barcodconvertersubsystem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BarcodeConverterControllerTest {
    private BarcodeConverterController barcodeConverterController ;
    @BeforeEach
    void setUp() {
        barcodeConverterController = new BarcodeConverterController();

    }

    @ParameterizedTest
    @CsvSource({
            "X01, 20210001"
    })
    void test(String barcode, int expected) {


        int bikeCode = barcodeConverterController.convertBarcodeToBikeCode(barcode);
        assertEquals(expected,bikeCode);
    }

}