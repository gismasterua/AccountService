package account;


import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
