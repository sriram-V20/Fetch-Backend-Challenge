import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.TestBrowser;

import static org.junit.Assert.*;
import static play.test.Helpers.*;
import play.Application;
import play.test.WithBrowser;


public class ReceiptWebServiceTest extends WithBrowser {

    protected Application provideApplication() {
        return fakeApplication(inMemoryDatabase());
    }

    protected TestBrowser provideBrowser(int port) {
        return Helpers.testBrowser(port);
    }

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
//    @Test
//    public void test() {
//        browser.goTo("http://localhost:" + play.api.test.Helpers.testServerPort());
//        assertTrue(browser.pageSource().contains(null));
//    }

    @Test
    public void processReceiptTest() throws JsonProcessingException {
        Result result = sendPostRequest("/receipts/process",Testcases.json1);
        assertEquals(OK, result.status());
        Assert.assertNotNull(contentAsString(result));
    }

    @Test
    public void processReceiptTest2() throws JsonProcessingException {
        Result result = sendPostRequest("/receipts/process",Testcases.json2);
        assertEquals(OK, result.status());
        Assert.assertNotNull(contentAsString(result));
    }

    @Test
    public void processReceiptTest3() throws JsonProcessingException {
        Result result = sendPostRequest("/receipts/process",Testcases.json3);
        assertEquals(OK, result.status());
        Assert.assertNotNull(contentAsString(result));
    }

    @Test
    public void processReceiptTest4() throws JsonProcessingException {
        Result result = sendPostRequest("/receipts/process",Testcases.json4);
        assertEquals(OK, result.status());
        Assert.assertNotNull(contentAsString(result));
    }

    @Test
    public void processReceiptTest5() throws JsonProcessingException {
        Result result = sendPostRequest("/receipts/process",Testcases.json5);
        assertEquals(OK, result.status());
        Assert.assertNotNull(contentAsString(result));
    }

    @Test
    public void getPointsTest() throws JsonProcessingException {
        Result idResult = sendPostRequest("/receipts/process",Testcases.json1);
        String content = contentAsString(idResult);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode = objectMapper.readTree(contentAsString(sendGetRequest(jsonNode.get("id").asText())));
        Assert.assertEquals(28,jsonNode.get("points").asInt());
    }

    @Test
    public void getPointsTest2() throws JsonProcessingException {
        Result idResult = sendPostRequest("/receipts/process",Testcases.json2);
        String content = contentAsString(idResult);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode = objectMapper.readTree(contentAsString(sendGetRequest(jsonNode.get("id").asText())));
        Assert.assertEquals(109,jsonNode.get("points").asInt());
    }

    @Test
    public void getPointsTest3() throws JsonProcessingException {
        Result idResult = sendPostRequest("/receipts/process",Testcases.json3);
        String content = contentAsString(idResult);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode = objectMapper.readTree(contentAsString(sendGetRequest(jsonNode.get("id").asText())));
        Assert.assertEquals(102,jsonNode.get("points").asInt());
    }

    @Test
    public void getPointsTest4() throws JsonProcessingException {
        Result idResult = sendPostRequest("/receipts/process",Testcases.json4);
        String content = contentAsString(idResult);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode = objectMapper.readTree(contentAsString(sendGetRequest(jsonNode.get("id").asText())));
        Assert.assertEquals(53,jsonNode.get("points").asInt());
    }

    @Test
    public void getPointsTest5() throws JsonProcessingException {
        Result idResult = sendPostRequest("/receipts/process",Testcases.json5);
        String content = contentAsString(idResult);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode = objectMapper.readTree(contentAsString(sendGetRequest(jsonNode.get("id").asText())));
        Assert.assertEquals(25,jsonNode.get("points").asInt());
    }

    public Result sendPostRequest(String route, String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(body);
        Http.RequestBuilder requestBuilder = new Http.RequestBuilder()
                .method(POST)
                .uri(route)
                .bodyJson(jsonNode);
        Http.Request request = requestBuilder.build();

        return route(app, requestBuilder);
    }

    public Result sendGetRequest(String id){
        String requestUri = "/receipts/"+id+"/points";
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri(requestUri);

        return route(app, request);
    }
}
