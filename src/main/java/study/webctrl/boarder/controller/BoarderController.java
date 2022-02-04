package study.webctrl.boarder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.webctrl.boarder.service.BoarderService;
import study.webctrl.dto.BoardDTO;
import study.webctrl.dto.RegisterDTO;

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
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", boarderService.addUser(dto));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }

    @PostMapping(value = "/boarder/delete")
    public ModelAndView boarderDelete(Long seq) {
        log.info("Delete 실행");
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", boarderService.delUser(seq));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }

    @PostMapping(value = "/boarder/update")
    public ModelAndView boarderUpdate(Long seq) {
        log.info("update page 실행");
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", boarderService.findUser(seq));
        mv.setViewName("/boarder/BoarderUpdate.html");
        return mv;
    }

    @PostMapping(value = "/boarder/updatedo")
    public ModelAndView boarderUpdateDo(ModelAndView mv, RegisterDTO rdto) {
        log.info("update 실행");
        log.info(rdto.getEmail());
        log.info(rdto.getPasswd());
        mv.addObject("userList", boarderService.updateUser(rdto));
        mv.setViewName("redirect:/boarder/list");
        return mv;
    }
}
