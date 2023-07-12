package services;

import Models.Receipt;

import java.util.Hashtable;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class ReceiptProcessingService {

    private static final Hashtable<UUID, Receipt> idToReceitMap = new Hashtable<>();

    public UUID processReceipt(Receipt receipt) {
        UUID id = UUID.randomUUID();
        idToReceitMap.put(id,receipt);
        return id;
    }

    public int getPoints(UUID receiptId) {
        return idToReceitMap.get(receiptId).getPoints();
    }
}
