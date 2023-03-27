
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class PruebaOrangeLogin extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://opensource-demo.orangehrmlive.com")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("application/json")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:104.0) Gecko/20100101 Firefox/104.0");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
    headers_0.put("Origin", "https://opensource-demo.orangehrmlive.com");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Cache-Control", "public, only-if-cached, stale-while-revalidate, max-age=60");
    headers_1.put("If-None-Match", "8Q1p80FipuZLcMYMjcvNsk8yqiF9bj+ewL0FVum3hfw=");
    headers_1.put("Sec-Fetch-Dest", "empty");
    headers_1.put("Sec-Fetch-Mode", "cors");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Accept", "image/avif,image/webp,*/*");
    headers_2.put("Sec-Fetch-Dest", "image");
    headers_2.put("Sec-Fetch-Mode", "no-cors");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
    headers_4.put("Sec-Fetch-Dest", "empty");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");


    ScenarioBuilder scn = scenario("PruebaOrangeLogin")
      .exec(
        http("request_0")
          .post("/web/index.php/auth/validate")
          .headers(headers_0)
          .formParam("_token", "092e79ba520be9d94.UCZdtaH57m2suZDOu9selkJLPGeWcv753b_zzdMZs64.BE1wxta6lAXnyMi2_-xE3SQeUg78GK6VkcqYrOtvyvcSSTvMxb6IXMiJ-w")
          .formParam("username", "Admin")
          .formParam("password", "admin123")
          .resources(
            http("request_1")
              .get("/web/index.php/core/i18n/messages")
              .headers(headers_1),
            http("request_2")
              .get("/web/images/orange.png?1660914792648")
              .headers(headers_2),
            http("request_3")
              .get("/web/images/orangehrm-logo.png?1660914792648")
              .headers(headers_2),
            http("request_4")
              .get("/web/index.php/api/v2/admin/job-titles")
              .headers(headers_4),
            http("request_5")
              .get("/web/index.php/api/v2/pim/employees?limit=50&offset=0&model=detailed&includeEmployees=onlyCurrent&sortField=employee.firstName&sortOrder=ASC")
              .headers(headers_4),
            http("request_6")
              .get("/web/index.php/api/v2/admin/employment-statuses")
              .headers(headers_4),
            http("request_7")
              .get("/web/index.php/pim/viewPhoto/empNumber/7")
              .headers(headers_2),
            http("request_8")
              .get("/web/index.php/api/v2/admin/subunits")
              .headers(headers_4)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(10))).protocols(httpProtocol);
  }
}
