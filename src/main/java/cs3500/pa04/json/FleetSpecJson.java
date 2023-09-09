package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a FleetSpec Json Object
 *
 * @param numCarriers the number of carriers
 * @param numBattleships the number of battleships
 * @param numDestroyers the number of destroyers
 * @param numSubmarines the number of submarines
 */
public record FleetSpecJson(
    @JsonProperty("CARRIER") int numCarriers,
    @JsonProperty("BATTLESHIP") int numBattleships,
    @JsonProperty("DESTROYER") int numDestroyers,
    @JsonProperty("SUBMARINE") int numSubmarines) {
}
