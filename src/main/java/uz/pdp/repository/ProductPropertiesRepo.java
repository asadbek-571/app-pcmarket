package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.entity.ProductProperties;
import uz.pdp.entity.User;
import uz.pdp.projection.CustomProductProperties;
import uz.pdp.projection.CustomUser;

@RepositoryRestResource(path = "productProperties",excerptProjection = CustomProductProperties.class)
public interface ProductPropertiesRepo extends JpaRepository<ProductProperties,Long> {
}
