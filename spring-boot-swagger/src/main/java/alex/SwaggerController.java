package alex;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 2016/12/27.
 */
@RestController
@RequestMapping("/api/v1/swagger")
public class SwaggerController {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerController.class);

    @ApiOperation(value = "获取API基本信息", httpMethod = "GET", response = Map.class, notes = "获取API基本信息")
    @GetMapping(value = "/info")
    public Map<String, String> queryApiInfo() {
        logger.info("query update version");
        Map<String, String> map = Maps.newHashMap();
        map.put("language", "Java");
        map.put("format", "JSON");
        map.put("tools", "swagger");
        map.put("version", "1.0");
        return map;
    }

    @ApiOperation(value = "query data with parameters")
    @GetMapping(value = "/data")
    public Map<String, String> queryData(@RequestParam String words) {
        logger.info("query data");
        Map<String, String> map = Maps.newHashMap();
        map.put("keyword", words);
        map.put("data", "this is demo data");
        return map;
    }
}
