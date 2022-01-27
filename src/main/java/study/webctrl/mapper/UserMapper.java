package study.webctrl.mapper;

import study.webctrl.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<BoardDTO> findAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    BoardDTO findById(Long seq);

}