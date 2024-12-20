package MRTS.DTO.mapper;

import MRTS.DTO.UserResponse;
import MRTS.domain.User;
import MRTS.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UserResponseMapper {
    private final JwtService jwtService;
    public UserResponse toUserResponse(User user, UUID userId) {
        UserResponse userResponse = new UserResponse();
        userResponse.setJwtToken(jwtService.generateToken(user));
        userResponse.setExpiresIn(jwtService.getExpirationTime());
        userResponse.setId(user.getId());
        userResponse.setUserFullName(user.getFullName());
        userResponse.setUserEmail(user.getEmail());
        userResponse.setUserStatus(user.getStatus());
        userResponse.setRole(user.getRole());
        userResponse.setUserId(userId);
        return userResponse;
    }
}
