package services;

import account.UserExistException;
import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public void addUser(User user){

        System.out.println(user);

        if (user.getName() == null || user.getName().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getLastname() == null || user.getLastname().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword() == null || user.getPassword().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail() == null || user.getEmail().equals("") || !user.getEmail().endsWith(emailDomain)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findAllByEmail(user.getEmail()).size() > 0){
            throw new UserExistException(userExistsErrorMessage);
        }
        User savedUser = userRepository.save(user);
    }
}
