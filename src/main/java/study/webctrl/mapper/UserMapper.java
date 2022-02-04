package study.webctrl.mapper;

import org.apache.ibatis.annotations.*;
import study.webctrl.dto.BoardDTO;
import study.webctrl.dto.RegisterDTO;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<BoardDTO> findAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    BoardDTO findById(Long seq);

    @Select("SELECT * FROM USERS where email = #{email}")
    BoardDTO findByEmail(String email);

    @Insert("INSERT INTO USERS(email, passwd, login_count, last_login_at, create_at) VALUES (#{email},#{passwd},0,now(),now())")
    int addUsers(BoardDTO dto);

    @Delete("DELETE FROM USERS where seq = #{seq}")
    int deleteUsers(Long seq);

    @Update("UPDATE USERS SET email= #{email}, passwd = #{passwd} where seq = #{seq}")
    int updateUsers(RegisterDTO rdto);
}