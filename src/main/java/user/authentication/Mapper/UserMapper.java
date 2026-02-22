package user.authentication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import user.authentication.dto.request.LoginRequest;
import user.authentication.dto.response.LoginResponse;
import user.authentication.dto.response.UserGetResponse;
import user.authentication.dto.request.UserPostRequest;
import user.authentication.dto.response.UserPostResponse;
import user.authentication.dto.request.UserPutRequest;
import user.authentication.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toUser(UserPostRequest postRequest);

    @Mapping(target = "id", ignore = true)
    User toUser(UserPutRequest putRequest);

    UserPostResponse toUserPostResponse(User user);

    UserGetResponse toUserGetResponse(User user);

    List<UserGetResponse> toUserGetResponseList(List<User> users);



}
