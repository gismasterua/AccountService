package account;

import dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public String emailDomain(){
        return "@acme.com";
    }
}
