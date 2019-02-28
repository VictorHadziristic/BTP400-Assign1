package Assign1;

enum orderStatus {UNFULFILLED, FULFILLED}

public class Order {
    Part part;
    orderStatus orderStatus;

    public Part getPart() {
        return part;
    }

    public Assign1.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Assign1.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(Part part, Assign1.orderStatus orderStatus) {
        this.part = part;
        this.orderStatus = orderStatus;
    }
}
