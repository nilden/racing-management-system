package se.cag.labs.cagrms.admin.resources.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = HealthInfo.HealthInfoBuilder.class)
public class HealthInfo {

    private String name;
    private final String status;
    private final Mongo mongo;
    @JsonIgnore
    private final DiskSpace diskSpace;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class HealthInfoBuilder {
    }
}
