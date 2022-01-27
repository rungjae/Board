package study.webctrl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import study.webctrl.service.BoardService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final BoardService boardService;
}
