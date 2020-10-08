package pl.coderslab.geze_calculator.product;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.math_formula.MathFormula;
import pl.coderslab.geze_calculator.product_type.ProductType;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
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
    @JoinColumn(nullable = false)
    private ProductType productType;
    @ManyToOne
    private MathFormula mathFormula;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", defQuantity=" + defQuantity +
                ", Typ towaru=" + productType +
                ", Wzór=" + mathFormula +
                '}';
    }
}
