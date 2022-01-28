package study.webctrl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.webctrl.dto.BoardDTO;
import study.webctrl.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final BoardService boardService;

    @GetMapping(value = "/jsboard")
    public ModelAndView mainScreen(ModelAndView mv) {
        log.info("mainScreen 실행");
        mv.setViewName("index.html");
        return mv;
    }

    @RequestMapping(value = "/finduser" , method = RequestMethod.POST)
    public ModelAndView findUser(ModelAndView mv, Long seq){
        log.info("findUser 실행");
        BoardDTO dto = boardService.findUser(seq);
        mv.setViewName("board.html");
        return mv;
    }

//    @RequestMapping(value ="/finduser", method = RequestMethod.POST)
//    public String samplecontent3(HttpServletRequest httpServletRequest, Model model) {
//        String seq = httpServletRequest.getParameter("seq");
//        model.addAttribute("seq", seq);
//        return "/userinfo";
//    }
//
//    @RequestMapping(value ="/finduser", method = RequestMethod.POST)
//    public String samplecontent(BoardDTO member) {
//        return "/userinfo";
//    }


//    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
//    public ModelAndView userInfo(ModelAndView mv, String userId) {
//        log.info("userInfo 실행");
//        Long seq = Long.parseLong(userId);
//        BoardDTO dto = boardService.findUser(seq);
//        mv.addObject("seq", dto.getSeq());
//        mv.addObject("email", dto.getEmail());
//        mv.addObject("passwd", dto.getPasswd());
//        mv.addObject("last_login_at", dto.getLast_login_at());
//        mv.setViewName("userinfo.html");
//        return mv;
//    }

    @RequestMapping(value = "/userinfo_seq", method = RequestMethod.POST)
    public ModelAndView findUser(HttpServletRequest httpServletRequest) {
        String str = httpServletRequest.getParameter("seq");
        Long seq = Long.parseLong(str);
        ModelAndView mv = new ModelAndView();
        BoardDTO dto = boardService.findUser(seq);
        mv.addObject("seq", dto.getSeq());
        mv.addObject("email", dto.getEmail());
        mv.addObject("passwd", dto.getPasswd());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String last_login_at = dto.getLast_login_at().format(dateTimeFormatter);
        String create_at = dto.getCreate_at().format(dateTimeFormatter);

        mv.addObject("last_login_at", last_login_at);
        mv.addObject("create_at", create_at);
        mv.setViewName("userinfo.html");
        return mv;
    }
    //리스트 출력 방법이 어려움..
    @RequestMapping(value = "/userinfo_email", method = RequestMethod.POST)
    public ModelAndView findEmail(HttpServletRequest httpServletRequest) {
        String str = httpServletRequest.getParameter("email");
        ModelAndView mv = new ModelAndView();
        List<BoardDTO> dto = boardService.findEmail(str);

        mv.setViewName("emailinfo.html");
        return mv;
    }
    //매핑오류..
    @RequestMapping(value = "/userinfo_insert", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView();
        String email = httpServletRequest.getParameter("email");
        String passwd = httpServletRequest.getParameter("passwd");
        BoardDTO dto = boardService.addUser(email, passwd);
        mv.addObject("seq", dto.getSeq());
        mv.addObject("email", email);
        mv.addObject("passwd", passwd);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String last_login_at = dto.getLast_login_at().format(dateTimeFormatter);
        String create_at = dto.getCreate_at().format(dateTimeFormatter);
        mv.addObject("last_login_at", last_login_at);
        mv.addObject("create_at", create_at);
        mv.setViewName("userInsert.html");
        return mv;
    }



}




