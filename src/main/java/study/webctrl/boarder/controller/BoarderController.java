package study.webctrl.boarder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.webctrl.boarder.service.BoarderService;
import study.webctrl.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor

public class BoarderController {
    private final BoarderService boarderService;
    Long tempSeq;
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
        tempSeq = dto.getSeq();
        mv.addObject("emailValue", dto.getEmail());
        mv.addObject("passwdValue", dto.getPasswd());
        mv.setViewName("/boarder/BoarderUpdate.html");
        return mv;
    }

    @PostMapping(value = "/boarder/updatedo")
    public ModelAndView boarderUpdateDo(@RequestParam("emailup")String email, @RequestParam("passwdup")String passwd, Long seq) {
        log.info("update 실행");
        ModelAndView mv = new ModelAndView();
        log.info(email);
        log.info(passwd);
        log.info(String.valueOf(tempSeq));
        boarderService.updateUser(email, passwd, tempSeq);
        mv.addObject("userList", boarderService.allUserList());
        mv.setViewName("/boarder/BoarderList.html");
        return mv;
    }
}
