package my.test.dto;

import jakarta.validation.constraints.NotNull;

public class PriceDTO {

    @NotNull
    public Integer productNo;

    @NotNull
    public String chainName;

    @NotNull
    public float regularPricePerUnit;
}
