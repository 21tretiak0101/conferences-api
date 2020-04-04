package by.ttre16.tracker.configuration;

import by.ttre16.tracker.entity.Conference;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class ConferencesConfiguration {

    private static final String RESOURCES_CONFERENCES_JSON = "src/main/resources/conferences.json";

    @Bean
    public List<Conference> conferencesList() {
        try {
            return objectMapper()
                    .readValue(new File(RESOURCES_CONFERENCES_JSON),
                            new TypeReference<>() {});
        } catch (IOException e) {
            throw new BeanCreationException("conferenceList", e.getMessage());
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
