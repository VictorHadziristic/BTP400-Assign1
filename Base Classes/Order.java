package Assign1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Order implements Serializable {
    Map<Part, Integer> parts;
    orderStatus orderStatus;
    //Station station;

    public Map<Part, Integer> getParts() {
        return parts;
    }

    public Assign1.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Assign1.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(Map<Part, Integer> parts, Assign1.orderStatus orderStatus) {
        this.parts = parts;
        this.orderStatus = orderStatus;
        //this.station = station;
    }
}
