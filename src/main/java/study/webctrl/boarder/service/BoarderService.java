package study.webctrl.boarder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.webctrl.dto.BoardDTO;
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

    public void addUser(BoardDTO dto) {
        userMapper.addUsers(dto);
    }

    public void delUser(Long seq){
        userMapper.deleteUsers(seq);
    }

    public void updateUser(String email, String passwd, Long seq){
        userMapper.updateUsers(email, passwd, seq);
    }
}
