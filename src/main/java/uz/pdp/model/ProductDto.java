package uz.pdp.model;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.entity.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private Long price;

    private boolean active;

    private Long category;
}
