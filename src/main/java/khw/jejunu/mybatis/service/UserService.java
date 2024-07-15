package khw.jejunu.mybatis.service;

import khw.jejunu.mybatis.dto.UserDTO;
import khw.jejunu.mybatis.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    public List<UserDTO> selectAllUsers(){
        return userMapper.findAll();
    }

    public UserDTO selectUserById(Long id){
        return userMapper.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found error"));
    }

    public void insertUser(UserDTO userDTO){
        userMapper.save(userDTO);
    }

    public void deleteUserById(Long id){
        userMapper.deleteById(id);
    }
}
