package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long carId;
    private String mark;
    private int yearOfManufacture;
    private String color;
    private String bodyStyle;
    private String enumExchangeDescription;
    private String engine;
    private String version;
}
