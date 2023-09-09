package cs3500.pa04.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility for handling Json objects
 */
public class JsonUtils {

  /**
   * Converts a given record object to a JsonNode
   *
   * @param record a record to convert
   * @return a record converted into a JsonNode
   * @throws IllegalArgumentException if the given record cannot be converted
   */
  public static JsonNode serializeRecord(Record record) throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.convertValue(record, JsonNode.class);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Record cannot be serialized.");
    }
  }

}
