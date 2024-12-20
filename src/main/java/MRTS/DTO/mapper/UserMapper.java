package MRTS.DTO.mapper;

import MRTS.DTO.UserDto;
import MRTS.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setUserFullName(user.getFullName());
        userDto.setUserEmail(user.getEmail());
        userDto.setUserPassword(passwordEncoder.encode(user.getPassword()));
        userDto.setUserStatus(user.getStatus());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setFullName(userDto.getUserFullName());
        user.setEmail(userDto.getUserEmail());
        user.setPassword(passwordEncoder.encode(userDto.getUserPassword()));
        user.setStatus(userDto.getUserStatus());
        user.setRole(userDto.getRole());
        user.setStatus(userDto.getUserStatus());
        return user;
    }
}
