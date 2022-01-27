package study.webctrl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.webctrl.dto.BoardDTO;
import study.webctrl.mapper.UserMapper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    private final UserMapper userMapper;
    public List<BoardDTO> findAllUser(){
        return userMapper.findAll();
    }
    public BoardDTO findUser(Long seq) {
        return userMapper.findById(seq);
    }
}
