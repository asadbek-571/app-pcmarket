package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.entity.PaymentHistory;
import uz.pdp.entity.User;
import uz.pdp.projection.CustomPaymentHistory;
import uz.pdp.projection.CustomUser;

@RepositoryRestResource(path = "paymentHistory",excerptProjection = CustomPaymentHistory.class)
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Long> {
}
