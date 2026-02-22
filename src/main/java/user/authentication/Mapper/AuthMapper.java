package user.authentication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import user.authentication.dto.response.LoginResponse;
import user.authentication.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthMapper {
    LoginResponse toUserLoginResponse (User user);
}
