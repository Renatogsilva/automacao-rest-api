package model.dto;

import lombok.*;
import model.enumerators.EnumExchange;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CarRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long carId;
    private String mark;
    private Integer yearOfManufacture;
    private String color;
    private String bodyStyle;
    private int exchange;
    private String engine;
    private String version;
}
