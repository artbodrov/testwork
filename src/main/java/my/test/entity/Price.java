package my.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "prices")
@Getter
@Setter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "chain_name")
    private String chainName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "material_no",
            referencedColumnName = "material_no",
            foreignKey = @ForeignKey(name = "fk_prices_products"))
    private Product product;

    @NotNull
    @Column(name = "regular_price_per_unit")
    private float RegularPricePerUnit;
}
