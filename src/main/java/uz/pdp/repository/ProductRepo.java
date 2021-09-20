package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.entity.Product;
import uz.pdp.entity.User;
import uz.pdp.projection.CustomProduct;
import uz.pdp.projection.CustomUser;

@RepositoryRestResource(path = "product",excerptProjection = CustomProduct.class)
public interface ProductRepo extends JpaRepository<Product,Long> {
}
