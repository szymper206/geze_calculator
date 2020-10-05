package pl.coderslab.geze_calculator.assortment_products;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.geze_calculator.assortment.Assortment;


import javax.persistence.*;


@Getter
@Setter
@Entity
public class AssortmentProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Assortment assortment;
    private String name;
    private long idNumber;
    private double quantity;

    @Override
    public String toString() {
        return "AssortmentProducts{" +
                "id=" + id +
                ", assortment=" + assortment +
                ", name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", quantity=" + quantity +
                '}';
    }
}
