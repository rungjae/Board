package study.webctrl.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class BoardDTO {
    private Long seq;
    private String email;
    private String passwd;
    private int login_count;
    private LocalDateTime last_login_at;
    private LocalDateTime create_at;
}
