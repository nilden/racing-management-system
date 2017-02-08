package se.cag.labs.cagrms.admin.resources.apimodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DiskSpace.DiskSpaceBuilder.class)
public class DiskSpace {

    private final String status;
    private final long total;
    private final long free;
    private final long threshold;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class DiskSpaceBuilder {
    }
}
