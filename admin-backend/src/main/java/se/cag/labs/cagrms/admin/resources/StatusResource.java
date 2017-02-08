package se.cag.labs.cagrms.admin.resources;


import lombok.extern.log4j.Log4j;
import se.cag.labs.cagrms.admin.AdminConfiguration;
import se.cag.labs.cagrms.admin.resources.apimodel.Mongo;
import se.cag.labs.cagrms.admin.resources.apimodel.HealthInfo;
import se.cag.labs.cagrms.admin.resources.mapper.ModelMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/admin/")
@Log4j
public class StatusResource {

    public static final String SERVICE_DOWN = "Down";
    public static final String URL_PART_HEALTH = "/health";
    private Client client;
    private AdminConfiguration configuration;
    private List<String> services;

    public StatusResource(AdminConfiguration configuration, Client client) {
        this.configuration = configuration;
        this.client = client;
        services = Arrays.asList(configuration.getUrlLeaderboardBaseURI(),
                configuration.getUrlCurrentRaceBaseURI(),
                configuration.getUrlRaceAdministratorBaseURI(),
                configuration.getUrlUserManagerBaseURI(),
                configuration.getUrlClientAPIBaseURI());
    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public List<se.cag.labs.cagrms.admin.api.HealthInfo> getHealthChecks() {
        log.info("GET /status");

        List<HealthInfo> healthInfos = services.stream()
                .map(s -> healthCheck(s))
                .collect(Collectors.toList());

        return ModelMapper.createServiceResponse(healthInfos);
    }

    private HealthInfo healthCheck(String target) {
        log.info("Performing health check on " + target + URL_PART_HEALTH);
        WebTarget webTarget = client.target(target + URL_PART_HEALTH);
        Invocation.Builder invocationBuilder =  webTarget.request();

        try {
            Response response = invocationBuilder.get();
            HealthInfo healthInfo = response.readEntity(HealthInfo.class);
            healthInfo.setName(mapName(target));
            return healthInfo;
        } catch(Exception e) {
            log.warn("Service not responding on " + target);
            return HealthInfo.builder()
                    .name(mapName(target))
                    .status(SERVICE_DOWN)
                    .mongo(Mongo.builder().status(SERVICE_DOWN).build())
                    .build();
        }
    }

    private String mapName(String target) {
        return "NOT IMPLEMENTED!";
    }

}

