package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a Coordinate Json Object
 *
 * @param coords a list of coords
 */
public record CoordinatesJson(
    @JsonProperty("coordinates") CoordJson[] coords) {
}
