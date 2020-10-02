package pl.coderslab.geze_calculator.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.geze_calculator.product_type.ProductType;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    private long idNumber;
    private double defQuantity;
    @ManyToOne
    private ProductType productType;

}
