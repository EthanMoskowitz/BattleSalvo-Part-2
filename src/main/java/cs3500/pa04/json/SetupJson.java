package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a Setup Json Object
 *
 * @param height the height of the board
 * @param width the width of the board
 * @param fleetSpec the fleet to initialize
 */
public record SetupJson(
    @JsonProperty("height") int height,
    @JsonProperty("width") int width,
    @JsonProperty("fleet-spec") FleetSpecJson fleetSpec) {
}
