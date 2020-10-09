package pl.coderslab.geze_calculator.product_group;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.product_type.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Proszę podać nazwę grupy towarowej")
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "productGroup", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductType> productTypes =
            new ArrayList<>();

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
