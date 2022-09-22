package services;

import account.UserExistException;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private String emailDomain;

    @Autowired
    private String userExistsErrorMessage;

    @Autowired
    PasswordEncoder encoder;

    public void addUser(User user){

        System.out.println(user);

        if (user.getName() == null || user.getName().equals("")){
            System.out.println("name");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getLastname() == null || user.getLastname().equals("")){
            System.out.println("lastname");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword() == null || user.getPassword().equals("")){
            System.out.println("password");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail() == null || user.getEmail().equals("") || !user.getEmail().endsWith(emailDomain)){
            System.out.println("email");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findAllByEmail(user.getEmail().toLowerCase()).size() > 0){
            System.out.println("UserExistException");
            throw new UserExistException(userExistsErrorMessage);
        }
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        User savedUser = userRepository.save(user);
    }

    public User getUser(String userEmail){

        return userRepository.findUserByEmail(userEmail.toLowerCase());
    }
}
