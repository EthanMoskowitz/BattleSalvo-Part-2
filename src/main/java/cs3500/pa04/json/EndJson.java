package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa03.model.GameResult;

/**
 * Record for an End Json Object
 *
 * @param result a GameResult
 * @param reason the reason for the result
 */
public record EndJson(
    @JsonProperty("result") GameResult result,
    @JsonProperty("reason") String reason) {
}
