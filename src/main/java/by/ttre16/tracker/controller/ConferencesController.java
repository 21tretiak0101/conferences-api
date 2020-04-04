package by.ttre16.tracker.controller;

import by.ttre16.tracker.entity.Conference;
import by.ttre16.tracker.exception.ConferenceExistsException;
import by.ttre16.tracker.service.ConferencesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class ConferencesController {

    private static final String NOT_FOUND_MESSAGE =
            "Conferences with this request parameters don't exist.";

    private static final String NOT_FOUND_BY_ID_MESSAGE =
            "Conference doesn't exist with ID: ";

    private ConferencesService conferencesService;


    @Autowired
    public ConferencesController(ConferencesService conferencesService) {
        this.conferencesService = conferencesService;
    }

    @GetMapping("/conferences")
    public ResponseEntity<List<Conference>> getConferences(
            @RequestParam(required = false, defaultValue = "") List<String> tags,
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam(required = false, defaultValue = "") String country,
            @RequestParam(required = false, defaultValue = "") String status,
            @RequestParam(required = false, defaultValue = "") String title) throws ConferenceExistsException {

        Map<String, String> params =  Map.of(
                "city", city, "country", country,
                "status", status, "title", title);

        log.info("PARAMS: {}, TAGS: {}", params.toString(), tags.toString());

        List<Conference> conferences = conferencesService.getConferencesByTagsAndParams(tags, params);

        if(conferences == null) throw new ConferenceExistsException(NOT_FOUND_MESSAGE);

        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable String id) throws ConferenceExistsException {
        Optional<Conference> conferenceOptional = conferencesService.getConferenceById(id);

        Conference conference = conferenceOptional.orElseThrow(
                () -> new ConferenceExistsException(NOT_FOUND_BY_ID_MESSAGE + id));

        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @ExceptionHandler(ConferenceExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundError(Exception e) {
        log.error(e.getMessage());
        return Map.of(
                "message", e.getMessage(),
                "error", e.getClass().getSimpleName());
    }
}
