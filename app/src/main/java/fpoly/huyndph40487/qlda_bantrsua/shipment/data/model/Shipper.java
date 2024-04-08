package fpoly.huyndph40487.qlda_bantrsua.shipment.data.model;


import java.io.Serializable;

import fpoly.huyndph40487.qlda_bantrsua.core.data.model.Person;

public class Shipper extends Person implements Serializable {
    private String signal;
    private double latitude;
    private double longitude;

    public Shipper() {
    }

    public Shipper(String id, String name, String phoneNumber, String email, String avatar, String signal, double latitude, double longitude) {
        super(id, name, phoneNumber, email, avatar);
        this.signal = signal;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
