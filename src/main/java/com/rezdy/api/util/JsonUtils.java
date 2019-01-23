package com.rezdy.api.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Encapsulate utility methods for JSON processing.
 * 
 * @author junfeng
 *
 */
public class JsonUtils {
  private static Logger LOG = LoggerFactory.getLogger(JsonUtils.class);

  /**
   * Get a collection of objects from the JSON file.
   * 
   * @param json contains JSON string representation
   * @param key referring the data collections
   * @param clazz carrying the object type
   * @return a collection of objects from the JSON file
   */
  public static <T> List<T> getDataFromJson(Resource json, String key, Class<T> clazz) {
    Map<String, List<T>> dataMap = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();

    try {
      dataMap =
          mapper.readValue(json.getInputStream(), new TypeReference<Map<String, List<T>>>() {});
    } catch (IOException exception) {
      LOG.error("Encountered an error when loading file {}.", json.getFilename());
    }

    LOG.debug("Successfully loaded all {} from file {}: {} ", key, json.getFilename(),
        dataMap.toString());
    return dataMap.getOrDefault(key, new ArrayList<>());
  }
}
