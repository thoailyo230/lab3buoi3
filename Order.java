import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Order {
    private int orderID;
    private LocalDate orderDate;
    private List<OrderDetail> lineItems;

    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.lineItems = new ArrayList<>();
    }

    public void addLineItem(Product product, int quantity) {
        if (lineItems.size() < 20) {
            lineItems.add(new OrderDetail(product, quantity));
        } else {
            System.out.println("Maximum number of line items reached for this order.");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (OrderDetail orderDetail : lineItems) {
            Product product = orderDetail.getProduct();
            int quantity = orderDetail.getQuantity();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public void printOrderDetails() {
        System.out.println("Ma HD: " + orderID);
        System.out.println("Ngay lap hoa don: " + orderDate);

        System.out.println("STT   |   MA SP   |   Mo ta   |   Don gia   |   So luong   |   Thanh tien");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < lineItems.size(); i++) {
            OrderDetail orderDetail = lineItems.get(i);
            Product product = orderDetail.getProduct();
            int quantity = orderDetail.getQuantity();
            double totalPrice = product.getPrice() * quantity;
            System.out.printf("%-6d|   %-8s|   %-9s|   %-11.2f|   %-12d|   %-11.2f\n", i + 1, "", product.getDescription(), product.getPrice(), quantity, totalPrice);
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Tong tien thanh toan: " + calculateTotalPrice() + " VND");
    }
}
