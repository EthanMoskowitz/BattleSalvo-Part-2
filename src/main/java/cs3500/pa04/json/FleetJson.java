package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a Fleet Json Object
 *
 * @param ships a list of ships
 */
public record FleetJson(
    @JsonProperty("fleet") ShipJson[] ships) {
}
