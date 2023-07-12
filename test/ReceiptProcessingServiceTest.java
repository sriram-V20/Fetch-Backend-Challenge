import Models.Receipt;
import akka.actor.ActorSystem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import controllers.ReceiptProcessorController;
import org.assertj.core.api.Assert;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.BeforeClass;
import org.junit.Test;
import play.mvc.Http;
import scala.concurrent.ExecutionContextExecutor;

import java.io.File;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import play.test.Helpers;
import services.ReceiptProcessingService;
import com.google.inject.Injector;

import javax.inject.Inject;

/**
 * Unit testing does not require Play application start up.
 *
 * https://www.playframework.com/documentation/latest/JavaTest
 */
public class ReceiptProcessingServiceTest {

    private final ReceiptProcessingService receiptProcessingService;

    public ReceiptProcessingServiceTest() {
        this.receiptProcessingService = new ReceiptProcessingService();
    }

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void testProcessingReceipt() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json1);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertNotNull(id);
    }

    @Test
    public void testProcessingReceipt2() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json2);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertNotNull(id);
    }

    @Test
    public void testProcessingReceipt3() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json3);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertNotNull(id);
    }

    @Test
    public void testProcessingReceipt4() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json4);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertNotNull(id);
    }

    @Test
    public void testProcessingReceipt5() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json5);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertNotNull(id);
    }

    @Test
    public void testPoints1() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json1);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertEquals(28,receiptProcessingService.getPoints(id));
    }

    @Test
    public void testPoints2() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json2);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertEquals(109,receiptProcessingService.getPoints(id));
    }

    @Test
    public void testPoints3() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json3);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertEquals(102,receiptProcessingService.getPoints(id),102);
    }

    @Test
    public void testPoints4() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json4);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertEquals(53,receiptProcessingService.getPoints(id));
    }

    @Test
    public void testPoints5() throws JsonProcessingException {
        Receipt receipt = getReceiptObject(Testcases.json5);
        UUID id = receiptProcessingService.processReceipt(receipt);
        assertEquals(25,receiptProcessingService.getPoints(id));
    }

    public Receipt getReceiptObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Receipt receipt = objectMapper.readValue(json, Receipt.class);
        return receipt;
    }

}
