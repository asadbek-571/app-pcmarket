package uz.pdp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Long getId();

    Category getParentCategory();

    String  getName();

    boolean  getActive();
}
