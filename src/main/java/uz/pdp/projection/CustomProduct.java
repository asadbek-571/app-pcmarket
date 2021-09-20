package uz.pdp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.entity.Category;
import uz.pdp.entity.Product;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Projection(types = Product.class)
public interface CustomProduct {

    Long getId();

    String getName();

    Long getPrice();

    boolean getActive();

    Category getCategory();
}
