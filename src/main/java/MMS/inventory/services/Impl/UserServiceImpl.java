package MMS.inventory.services.Impl;

import MMS.inventory.DTO.UserDto;
import MMS.inventory.DTO.mapper.UserMapper;
import MMS.inventory.Exception.ResourceNotFoundException;
import MMS.inventory.model.User;
import MMS.inventory.repository.UserRepository;
import MMS.inventory.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    @Override
//    public UserDto findByUsername(String username) {
//        User user = userRepository.findByUsername(username);
//        if(user == null) {
//            throw new ResourceNotFoundException("User not found with username: " + username);
//        }
//        return userMapper.toUserDto(user);
//    }

//    @Override
//    public UserDto findByEmail(String email) {
//        User user = userRepository.findByEmail(email);
//        if(user == null) {
//            throw new ResourceNotFoundException("User not found with email: " + email);
//        }
//        return userMapper.toUserDto(user);
//    }


    @Override
    public UserDto createUser(UserDto user) {
        if(user == null) {
            throw new ResourceNotFoundException("User cannot be null");
        }
        return userMapper.toUserDto(userRepository.save(userMapper.toUser(user)));
    }

    @Override
    public UserDto updateUserById(Long userId, UserDto userDto) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        User user = userMapper.toUser(userDto);
        userToUpdate.setName(user.getName());
        userToUpdate.setType(user.getType());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setStatus(user.getStatus());
        return userMapper.toUserDto(userRepository.save(userToUpdate));
    }

    @Override
    public void deleteUserById(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }
}
