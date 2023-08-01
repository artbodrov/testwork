package my.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {


    @Id
    @Column(name = "ship_to_code")
    private Integer shipToCode;

    @NotNull
    @Column(name = "ship_to_name")
    private String shipToName;

    @NotNull
    @Column(name = "chain_name")
    private String chainName;
}
