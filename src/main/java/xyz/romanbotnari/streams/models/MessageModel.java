package xyz.romanbotnari.streams.models;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
// @ToString(of = {"id", "message", "messageDate"})
public class MessageModel {

    @JsonProperty("id")
    private String id = UUID.randomUUID().toString();

    @JsonProperty("message")
    private String message;

    @JsonProperty("messageDate")
    private LocalDate messageDate = LocalDate.now();

    public MessageModel(String id, String message, LocalDate date) {
        this.id = id;
        this.message = message;
        this.messageDate = date; 
    }

    public MessageModel() {

    }

    public static MessageModel newRandomMessageModel() {
        MessageModel mm = new MessageModel();
        mm.message = "Random";
        mm.id = UUID.randomUUID().toString();
        mm.messageDate = LocalDate.now();
        return mm;
    }
}