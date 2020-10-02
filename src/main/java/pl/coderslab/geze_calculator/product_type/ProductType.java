package pl.coderslab.geze_calculator.product_type;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.geze_calculator.product.Product;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @ManyToOne
    private ProductGroup productGroup;
    @OneToMany(mappedBy = "productType")
    private List<Product> products =
            new ArrayList<>();


}
