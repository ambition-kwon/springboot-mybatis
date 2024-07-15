package khw.jejunu.mybatis.mapper;

import khw.jejunu.mybatis.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(Long id);
    void save(UserDTO userDTO);
    void deleteById(Long id);
}
