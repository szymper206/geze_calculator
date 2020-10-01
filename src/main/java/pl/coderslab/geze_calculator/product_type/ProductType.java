package pl.coderslab.geze_calculator.product_type;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
public class ProdcutType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @ManyToOne
    private ProductGroup productGroup;
}
