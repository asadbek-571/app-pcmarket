package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.entity.Category;
import uz.pdp.entity.User;
import uz.pdp.projection.CustomCategory;
import uz.pdp.projection.CustomUser;

@RepositoryRestResource(path = "category",excerptProjection = CustomCategory.class)
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
