package uz.pdp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.entity.Category;
import uz.pdp.entity.Product;
import uz.pdp.entity.ProductProperties;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Projection(types = ProductProperties.class)
public interface CustomProductProperties {

    Long getId();

    String getKey();

    String getValue();

    Product getProduct();
}
