package controllers;

import Models.Receipt;
import akka.actor.ActorSystem;
import javax.inject.*;

import akka.actor.Scheduler;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.Json;
import play.mvc.*;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;
import scala.concurrent.ExecutionContextExecutor;
import services.ReceiptProcessingService;

/**
 * This controller processes requests in non-blocking approach i.e processing them asynchronously
 */
@Singleton
public class ReceiptProcessorController extends Controller {

    private final ActorSystem actorSystem;
    private final ExecutionContextExecutor exec;
    private final ReceiptProcessingService receiptProcessingService;
    /**
     * @param actorSystem We need the {@link ActorSystem}'s
     * {@link Scheduler} to run code after a delay.
     * @param exec We need a Java {@link Executor} to apply the result
     * of the {@link CompletableFuture} and a Scala
     * {@link ExecutionContext} so we can use the Akka {@link Scheduler}.
     * An {@link ExecutionContextExecutor} implements both interfaces.
     * @param receiptProcessingService
     */
    @Inject
    public ReceiptProcessorController(ActorSystem actorSystem, ExecutionContextExecutor exec, ReceiptProcessingService receiptProcessingService) {
      this.actorSystem = actorSystem;
      this.exec = exec;
      this.receiptProcessingService = receiptProcessingService;
    }

    public Result index(){
        return ok("Works fine");
    }

    public CompletionStage<Result> processReceipt(Http.Request request) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Receipt receipt = objectMapper.treeToValue(request.body().asJson(), Receipt.class);

        return processRequest( () -> {
            UUID id = receiptProcessingService.processReceipt(receipt);
            HashMap<String, UUID> response = new HashMap<>();
            response.put("id", id);
            return Json.toJson(response);
        });
    }

    public CompletionStage<Result> getPoints(Http.Request request, String id) throws Exception{
        UUID uuid  = UUID.fromString(id);

        return processRequest(() -> {
            int points = receiptProcessingService.getPoints(uuid);
            HashMap<String, Integer> response = new HashMap<>();
            response.put("points", points);
            return Json.toJson(response);
        });
    }

    private CompletionStage<Result> processRequest(Supplier<JsonNode> supplier) {
        return CompletableFuture.supplyAsync(supplier, exec).thenApplyAsync(Results::ok, exec);
    }
}
