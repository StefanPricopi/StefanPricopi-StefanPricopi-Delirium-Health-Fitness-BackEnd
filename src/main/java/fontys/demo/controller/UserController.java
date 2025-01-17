package fontys.demo.controller;

import fontys.demo.domain.login.LoginRequest;
import fontys.demo.domain.login.LoginResponse;
import fontys.demo.domain.userDomain.*;
import fontys.demo.business.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable("id") long userId) {
        GetUserResponse response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GetUserResponse>> getAllUsers() {
        List<GetUserResponse> responses = userService.getAllUsers();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {
        System.out.println("Register endpoint hit with username: " + request.getUsername());
        CreateUserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable("id") long userId, @RequestBody @Valid UpdateUserRequest request) {
        UpdateUserResponse response = userService.updateUser(userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        System.out.println("Login endpoint hit with username: " + request.getUsername());
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-username")
    public ResponseEntity<Boolean> checkUsername(@RequestParam String username) {
        boolean exists = userService.usernameExists(username);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/pts")
    public ResponseEntity<List<GetUserResponse>> getAllPTs() {
        List<GetUserResponse> pts = userService.getAllPTs();
        return ResponseEntity.ok(pts);
    }
}
