package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a Coord Json Object
 *
 * @param x an x-value
 * @param y a y-value
 */
public record CoordJson(
    @JsonProperty("x") int x,
    @JsonProperty("y") int y) {
}
