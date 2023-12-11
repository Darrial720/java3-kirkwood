package FinalExam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MusicArtistFromJson {
    @JsonProperty("data")
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }
}
