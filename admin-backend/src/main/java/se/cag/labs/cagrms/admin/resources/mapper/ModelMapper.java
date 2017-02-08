package se.cag.labs.cagrms.admin.resources.mapper;

import se.cag.labs.cagrms.admin.api.Race;
import se.cag.labs.cagrms.admin.resources.apimodel.HealthInfo;
import se.cag.labs.cagrms.admin.resources.apimodel.User;
import se.cag.labs.cagrms.admin.resources.apimodel.UserResult;

import java.util.List;
import java.util.stream.Collectors;

public final class ModelMapper {

    private ModelMapper() {
      //Not used
    }

    public static List<Race> createUserResultResponse(List<UserResult> userResults) {
      return userResults.stream()
              .map(ModelMapper::mapUserResultToRace)
              .collect(Collectors.toList());
    }


  private static Race mapUserResultToRace(UserResult userResult) {
    return Race.builder()
            .id(userResult.getId())
            .userId(userResult.getUser().getUserId())
            .splitTime(userResult.getSplitTime())
            .time(userResult.getTime())
            .resultType(userResult.getResult())
            .build();
  }


    public static List<User> createUserResponse(List<User> users) {
        return users.stream()
                .map(ModelMapper::mapUser)
                .collect(Collectors.toList());
    }

    private static User mapUser(User user) {
        return User.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .displayName(user.getDisplayName())
                .build();
    }

    public static List<se.cag.labs.cagrms.admin.api.HealthInfo> createServiceResponse(List<HealthInfo> statuses) {
        return statuses.stream()
                .map(ModelMapper::mapService)
                .collect(Collectors.toList());
    }

    private static se.cag.labs.cagrms.admin.api.HealthInfo mapService(HealthInfo healthInfo) {
        return se.cag.labs.cagrms.admin.api.HealthInfo.builder()
                .name(healthInfo.getName())
                .serviceUp("UP".equals(healthInfo.getStatus()) ? true : false)
                .dbUp("UP".equals(healthInfo.getStatus()) ? true : false)
                .info( new String []{"Not implemented!"})
                .build();
    }
}