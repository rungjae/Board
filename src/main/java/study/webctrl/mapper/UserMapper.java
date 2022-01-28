package study.webctrl.mapper;

import org.apache.ibatis.annotations.Insert;
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

    @Select("SELECT * FROM USERS where email = #{email}")
    BoardDTO findByEmail(String email);

    @Select("SELECT * FROM USERS where email = %#{email}%")
    List<BoardDTO> findMail(String email);

    @Insert("INSERT INTO USERS(email, passwd, login_count, last_login_at, create_at) VALUES (#{email},#{passwd},0,now(),now())")
    void addUsers(BoardDTO dto);
}