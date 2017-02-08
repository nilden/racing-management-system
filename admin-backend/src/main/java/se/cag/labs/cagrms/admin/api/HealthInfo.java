package se.cag.labs.cagrms.admin.api;

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

    private final String name;
    private final boolean serviceUp;
    private final boolean dbUp;
    private final String [] info;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class HealthInfoBuilder {
    }
}
