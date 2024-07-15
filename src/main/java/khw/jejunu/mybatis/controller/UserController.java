package khw.jejunu.mybatis.controller;

import khw.jejunu.mybatis.dto.UserDTO;
import khw.jejunu.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> selectAllUsers(){
        List<UserDTO> userDTOs = userService.selectAllUsers();
        return ResponseEntity.ok().body(userDTOs);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> selectUserById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.selectUserById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
