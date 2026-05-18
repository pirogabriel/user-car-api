package com.example.demo.user;

import com.example.demo.common.UserUtils;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.user.dto.UserResponseDTO;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;

@Service
public class UserService {
    private final UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserResponseDTO> getUsers(String name, int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")?Sort.by(sortBy).descending(): Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> users;
        if(name != null){
            users = userRepository.findByNameIgnoreCase(name, pageable);
        }
        else{
            users = userRepository.findAll(pageable);
        }
        return users.map(UserMapper::toResponse);
    }
    public UserResponseDTO getUserById (Integer id){
        log.info("Searching user with id {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> { log.error("User {} not found", id); return new UserNotFoundException("User not found");});
        return UserMapper.toResponse(user);
    }

    public Set<String> getUniqueNames(){
        return UserUtils.getUniqueNames(userRepository.findAll());
    }

    public List<UserDTO> getDTO(){
        return UserUtils.toDTO(userRepository.findAll());
    }

    public Map<String, Object> getSummary(){
        return UserUtils.userSummary(userRepository.findAll());
    }

    public List<User> getTop3Oldest(){
        return UserUtils.top3Oldest(userRepository.findAll());
    }

    public List<User> getAdults(){
        return UserUtils.onlyAdults(userRepository.findAll());
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public UserResponseDTO updateUser(Integer id, User updatedUser){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());

        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }

    public Map<String,String> deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(user);

        return Map.of("message", "User deleted");
    }
    public User getUserEntityById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
