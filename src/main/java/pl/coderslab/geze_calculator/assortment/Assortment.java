package pl.coderslab.geze_calculator.assortment;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.assortment_products.AssortmentProducts;
import pl.coderslab.geze_calculator.product_group.ProductGroup;
import pl.coderslab.geze_calculator.product_type.ProductType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Assortment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double length;
    private double width;
    private boolean painted;
    private String description;
    @OneToOne
    private ProductGroup productGroup;
    @OneToOne
    private ProductType productType;
    @OneToMany(mappedBy = "assortment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssortmentProducts> assortmentProducts =
            new ArrayList<>();

    @Override
    public String toString() {
        return "Assortment{" +
                "id=" + id +
                ", length=" + length +
                ", width=" + width +
                ", painted=" + painted +
                ", description='" + description + '\'' +
                ", productGroup=" + productGroup +
                ", productType=" + productType +
                '}';
    }
}
