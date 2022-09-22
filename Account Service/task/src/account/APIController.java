package account;


import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
public class APIController {

    @Autowired
    public UserService userService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/api/empl/payment")
    public ResponseEntity<User> getPayloads(Authentication auth){
        User foundUser = userService.getUser(auth.getName());
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}
