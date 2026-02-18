package user.authentication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import user.authentication.dto.UserGetResponse;
import user.authentication.dto.UserPostRequest;
import user.authentication.dto.UserPostResponse;
import user.authentication.dto.UserPutRequest;
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
