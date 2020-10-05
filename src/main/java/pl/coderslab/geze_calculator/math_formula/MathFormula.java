package pl.coderslab.geze_calculator.math_formula;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class MathFormula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "mathFormula")
    private List<Product> products =
            new ArrayList<>();

    @Override
    public String toString() {
        return "MathFormula{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
