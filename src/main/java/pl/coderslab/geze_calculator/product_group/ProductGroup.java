package pl.coderslab.geze_calculator.product_group;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.geze_calculator.product_type.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "productGroup")
    private List<ProductType> productTypes = new ArrayList<>();
}
