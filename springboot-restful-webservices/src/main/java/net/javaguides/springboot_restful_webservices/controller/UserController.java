package net.javaguides.springboot_restful_webservices.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot_restful_webservices.dto.UserDto;
import net.javaguides.springboot_restful_webservices.entity.User;
import net.javaguides.springboot_restful_webservices.exception.ErrorDetails;
import net.javaguides.springboot_restful_webservices.exception.ResourceNotFoundException;
import net.javaguides.springboot_restful_webservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get user by id REST API
    //http://localhost:6012/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
       UserDto user=userService.getUserById(userId);
       return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    //Build Get All Users REST API
    //http://localhost:6012/api/users
    @GetMapping
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto>users=userService.getAllUsers();
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    //Build Update User REST API
    //http://localhost:6012/api/users/1
    @PutMapping("{id}")
    public  ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody @Valid UserDto user){
       user.setId(userId);
        UserDto updatedUser=userService.updateUser(user);
       return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //Build Update User REST API
    //http://localhost:6012/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails=new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }


}
