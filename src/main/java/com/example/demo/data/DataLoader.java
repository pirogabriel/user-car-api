package com.example.demo.data;

import com.example.demo.auth.AppUser;
import com.example.demo.auth.AppUserRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args){
        userRepository.save(new User("Gabriel", 25));
        userRepository.save(new User("Mariana",17));
        userRepository.save(new User("Mauro",54));
        userRepository.save(new User("Renata",54));
        userRepository.save(new User("Gabriel",35));
        userRepository.save(new User("Jose",28));
        userRepository.save(new User("Mario",74));
        userRepository.save(new User("Paulo",60));
        userRepository.save(new User("Gabriel",2));
        userRepository.save(new User("Mariana",15));
        userRepository.save(new User("Jose",35));
        userRepository.save(new User("Joao",18));
        appUserRepository.save(new AppUser("gabriel", passwordEncoder.encode("123"), "ROLE_USER"));

    }
}
