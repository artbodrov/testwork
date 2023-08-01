package my.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "actual")
@Getter
@Setter
public class Actual {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "ship_to_code",
            referencedColumnName = "ship_to_code",
            foreignKey = @ForeignKey(name = "actuals_customers"))
    private Customer customer;

    @NotNull
    @Column(name = "chain_name")
    private String ChainName;

    @NotNull
    @Column(name = "units")
    private Integer VolumeUnits;

    @NotNull
    @Column(name = "actual_sales_value")
    private float actualSalesValue;

    @NotNull
    @Column(name = "promo", columnDefinition = "boolean default false")
    private boolean promo = false;

}
