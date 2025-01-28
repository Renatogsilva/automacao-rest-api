package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LoginRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
