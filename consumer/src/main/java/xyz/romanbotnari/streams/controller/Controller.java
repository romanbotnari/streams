package xyz.romanbotnari.streams.controller;

import xyz.romanbotnari.streams.services.*;
import xyz.romanbotnari.streams.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    @PostMapping("/configure")
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody ConsumerTestConfiguration ctc) {
        ResponseEntity<HttpStatus> response;
        log.info("/configure");
        log.info("Input {}", ctc);
        try { 
            ConsumerTestConfiguration.getInstance().setLag(ctc.getLag());
            response = new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
