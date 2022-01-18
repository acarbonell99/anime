package uf2.anime.anime.domain.dto;

import java.util.UUID;

public class ResponseFile {
    public UUID fileid;
    public String contenttype;

    public ResponseFile(UUID fileid, String contenttype) {
        this.fileid = fileid;
        this.contenttype = contenttype;
    }
}
