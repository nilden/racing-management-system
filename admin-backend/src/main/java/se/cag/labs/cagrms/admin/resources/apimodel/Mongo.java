package se.cag.labs.cagrms.admin.resources.apimodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = Mongo.MongoBuilder.class)
public class Mongo {
    private final String status;
    private final String version;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class MongoBuilder {
    }

}
