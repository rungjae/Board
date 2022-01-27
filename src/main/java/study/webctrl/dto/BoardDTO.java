package study.webctrl.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class BoardDTO {
    private int seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
}
