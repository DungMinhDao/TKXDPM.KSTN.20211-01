package entities;

public class SingleBike extends Bike {
    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeneralInfo(){
        return super.convertBikeCodeToBarCode(getBikeCode()) + " - " + type;
    }
    @Override
    public String toString() {
        return super.convertBikeCodeToBarCode(getBikeCode()) + " - " + type;
    }

    @Override
    public int calculateDeposit() {
        return 4 * getValue() / 10;
    }
}
