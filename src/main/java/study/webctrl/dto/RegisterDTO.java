package study.webctrl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO {
    private Long seq;
    private String email;
    private String passwd;
}
