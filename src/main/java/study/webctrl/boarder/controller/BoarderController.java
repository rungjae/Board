package study.webctrl.boarder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.webctrl.boarder.service.BoarderService;
import study.webctrl.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor

public class BoarderController {
    private final BoarderService boarderService;
    @GetMapping(value = "/boarder/list")
    public ModelAndView boarderList(ModelAndView mv) {
        log.info("List실행");
        mv.addObject("userList", boarderService.allUserList());
        mv.setViewName("/boarder/BoarderList.html");
        return mv;
    }

    @GetMapping(value = "/boarder/register")
    public ModelAndView boarderRegister() {
        log.info("register 실행");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/boarder/BoaderRegister.html");
        return mv;
    }

    @PostMapping(value = "/boarder/insert")
    public ModelAndView boarderInsert(BoardDTO dto) {
        log.info("Insert 실행");
        boarderService.addUser(dto);
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", boarderService.allUserList());
        mv.setViewName("/boarder/BoarderList.html");
        return mv;
    }

    @PostMapping(value = "/boarder/delete")
    public ModelAndView boarderDelete(Long seq) {
        log.info("Delete 실행");
        boarderService.delUser(seq);
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", boarderService.allUserList());
        mv.setViewName("/boarder/BoarderList.html");
        return mv;
    }

    @PostMapping(value = "/boarder/update")
    public ModelAndView boarderUpdate(Long seq) {
        log.info("update page 실행");
        BoardDTO dto = boarderService.findUser(seq);
        ModelAndView mv = new ModelAndView();
        mv.addObject("email", dto.getEmail());
        mv.addObject("passwd", dto.getPasswd());
        mv.setViewName("/boarder/BoarderUpdate.html");
        return mv;
    }

    @PostMapping(value = "/boarder/updatedo")
    public ModelAndView boarderUpdateDo(String email, String passwd, Long seq) {
        log.info("update 실행");
        ModelAndView mv = new ModelAndView();
        boarderService.updateUser(email,passwd,seq);
        mv.addObject("userList", boarderService.allUserList());
        mv.setViewName("/boarder/BoarderList.html");
        return mv;
    }
}
