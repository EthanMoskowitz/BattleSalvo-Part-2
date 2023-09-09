package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa04.Direction;

/**
 * Record for a Ship Json Object
 *
 * @param coord the starting coordinate
 * @param length the length
 * @param direction the direction
 */
public record ShipJson(
    @JsonProperty("coord") CoordJson coord,
    @JsonProperty("length") int length,
    @JsonProperty("direction") Direction direction) {
}
