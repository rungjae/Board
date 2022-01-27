package study.webctrl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.webctrl.dto.BoardDTO;
import study.webctrl.service.BoardService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final BoardService boardService;
    @GetMapping(value = "/jsboard")
    public ModelAndView mainScreen(ModelAndView mv, String email){
        log.info("mainScreen 실행");
        mv.setViewName("index.html");
        return mv;
    }

    @RequestMapping(value = "/jslist" , method = RequestMethod.POST)
    public ModelAndView findAllUser(ModelAndView mv){
        log.info("findAllUser 실행");
        List<BoardDTO> list=  boardService.findAllUser();
        mv.addObject("list", list);
        mv.setViewName("board.html");
        return mv;
    }
}
