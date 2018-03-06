package Income;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by USUARIO on 5/03/2018.
 */

public class Income {
    private String id;
    private int price;
    private String place;
    private String type;
    private String date;
    private boolean active;
    private Calendar now = new GregorianCalendar();

    public Income(String id,String place,String type) {
        this.id = id;
        this.price = type.equals("Moto") ? 10000 : 30000;
        this.place = place;
        this.type = type;
        this.date = now.getTime().toString();
        this.active = true;
    }
    public Income() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
