package uf2.anime.anime.domain.dto;

public class ResponseMessage {
    public String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public static ResponseMessage message(String message) {
        return new ResponseMessage(message);
    }
}
