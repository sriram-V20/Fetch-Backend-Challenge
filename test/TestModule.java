import com.google.inject.AbstractModule;
import services.ReceiptProcessingService;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReceiptProcessingService.class).to(ReceiptProcessingService.class);
    }
}