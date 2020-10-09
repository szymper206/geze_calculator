package pl.coderslab.geze_calculator.product_type;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.product.Product;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Proszę podać nazwę typu towaru")
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Należy wybrać grupę towarową")
    private ProductGroup productGroup;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> products =
            new ArrayList<>();

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
