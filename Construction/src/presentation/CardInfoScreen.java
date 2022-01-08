package presentation;

import businesslogic.controller.CheckCardInUseController;
import businesslogic.controller.RentBikeController;
import entities.Bike;
import entities.Card;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.box.NotificationBox;
import presentation.box.NotificationErrorCode;

import java.net.URL;
import java.util.ResourceBundle;

public class CardInfoScreen implements Initializable {
    public static Card card = new Card();

    @FXML
    private TextField text1, text2, text3, text4;

    @FXML
    private Button xacnhan, huy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text1.setText("kstn_group1_2021");
        text2.setText("Group 1");
        text3.setText("790");
        text4.setText("1125");
        xacnhan.setOnAction(e -> {

            CheckCardInUseController checkCardInUseController = new CheckCardInUseController();
            if (text1.getText().isEmpty() ||text2.getText().isEmpty() || text3.getText().isEmpty() || text4.getText().isEmpty()){
                NotificationBox.display("Notification", "Bạn vui lòng nhập đầy đủ thông tin thẻ!");
            }
            else{
                boolean check = checkCardInUseController.checkCardInUse(text1.getText());
                if (check){
                    card = new Card();
                    card.setCardCode(text1.getText());
                    card.setOwner(text2.getText());
                    card.setCVV(text3.getText());
                    card.setExpiredDate(text4.getText());
                    ((Stage) xacnhan.getScene().getWindow()).close();
                }
                else{
                    NotificationBox.display("NotificationBox", "Bạn cần sử dụng thẻ đã thuê xe để thanh toán");
                }
            }
        });
        huy.setOnAction(e ->  ((Stage) huy.getScene().getWindow()).close());
    }

    /**
     *
     * @param bike : thông tin đầu vào xe ứng với barcode người dùng đã nhập
     * @param bikeInfoStage : màn hình hiển thị thông tin xe
     * @param cardInfoStage : màn hình hiển thị thông tin thẻ
     */
    public void getInfo(Bike bike, Stage cardInfoStage, Stage bikeInfoStage){
        xacnhan.setOnAction(e -> {

            CheckCardInUseController checkCardInUseController = new CheckCardInUseController();
            if (text1.getText().isEmpty() ||text2.getText().isEmpty() || text3.getText().isEmpty() || text4.getText().isEmpty()){
                NotificationBox.display("Notification", "Bạn vui lòng nhập đầy đủ thông tin thẻ!");
            }
            else{
                boolean check = checkCardInUseController.checkCardInUse(text1.getText());
                if (check){
                    card.setCardCode(text1.getText());
                    card.setOwner(text2.getText());
                    card.setCVV(text3.getText());
                    card.setExpiredDate(text4.getText());
                    String code = RentBikeController.processRentBike(card, bike);
                    NotificationErrorCode.displayNotificationErrorCode(code, "pay");
                    if (code.equals("00")){
                        NotificationBox.display("RentalCode", "Mã thuê xe của bạn là: " + RentBikeController.rentalCode);
                        cardInfoStage.close();
                        bikeInfoStage.close();
                    }

                }
                else{
                    NotificationBox.display("NotificationBox", "Thẻ đang được sử dụng để thuê xe!");
                }
            }
        });
        huy.setOnAction(e ->  cardInfoStage.close());
    }

    public Card getCardInfo(){
        return card;
    }

    public static Card getCard() {
        return card;
    }
}
