package httptest.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import httptest.OrderApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer qty;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Payment payment;

    @Embedded
    private Money money;

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
