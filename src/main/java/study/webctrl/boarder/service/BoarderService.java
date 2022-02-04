package study.webctrl.boarder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.webctrl.dto.BoardDTO;
import study.webctrl.dto.RegisterDTO;
import study.webctrl.mapper.UserMapper;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class BoarderService {
    private final UserMapper userMapper;

    public BoardDTO findUser(Long seq) {
        return userMapper.findById(seq);
    }

    public List<BoardDTO> allUserList() {
        return userMapper.findAll();
    }

    public List<BoardDTO> addUser(BoardDTO dto) {
        int result = userMapper.addUsers(dto);
        String updateResult = "회원 추가 실패";
        if(result > 0) {
            updateResult = "회원 추가 성공";
        }
        log.info(updateResult);
        return userMapper.findAll();
    }

    public List<BoardDTO> delUser(Long seq){
        int result = userMapper.deleteUsers(seq);
        String updateResult = "회원 삭제 실패";
        if(result > 0) {
            updateResult = "회원 삭제 성공";
        }
        log.info(updateResult);
        return userMapper.findAll();
    }

    public List<BoardDTO> updateUser(RegisterDTO rdto){
        int result = userMapper.updateUsers(rdto);
        String updateResult = "회원 수정 실패";
        if(result > 0) {
            updateResult = "회원 수정 성공";
        }
        log.info(updateResult);
        return userMapper.findAll();
    }
}
