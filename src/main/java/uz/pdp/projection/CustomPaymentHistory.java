package uz.pdp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.entity.PaymentHistory;
import uz.pdp.entity.Product;
import uz.pdp.entity.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Projection(types = PaymentHistory.class)
public interface CustomPaymentHistory {

    Long getId();

    Product getProduct();

    User getUser();

    Timestamp getDate();
}
