package pl.coderslab.geze_calculator.product;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.geze_calculator.math_formula.MathFormula;
import pl.coderslab.geze_calculator.product_type.ProductType;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Proszę podać nazwę produktu")
    private String name;
    @Range(min = 6, message = "Numer powinien posiadać 6 cyfr")
    @Column(nullable = false, unique = true)
    private long idNumber;
    @Min(value = 0, message = "Wartość musi być równa lub większa 0")
    private double defQuantity;
    @NotNull(message = "Proszę wybrać typ produktu")
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
