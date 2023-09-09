package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record for a Join Json Object
 *
 * @param name the name of the player
 * @param type the type of game
 */
public record JoinJson(
    @JsonProperty("name") String name,
    @JsonProperty("game-type") GameType type) {
}
