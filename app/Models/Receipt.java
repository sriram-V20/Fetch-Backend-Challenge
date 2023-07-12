package Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class Receipt {
    @NotNull
    String retailer;
    @NotNull
    Date purchaseDate;
    @NotNull
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    LocalTime purchaseTime;
    @NotNull
    List<Item> items;
    @NotNull
    Double total;


    /**
     1. One point for every alphanumeric character in the retailer name.
     2. 50 points if the total is a round dollar amount with no cents.
     3. 25 points if the total is a multiple of 0.25.
     4. 5 points for every two items on the receipt.
     5. If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
     6. 6 points if the day in the purchase date is odd.
     7. 10 points if the time of purchase is after 2:00pm and before 4:00pm.
     4,8,9
     */
    public int getPoints(){
        int points=0;

        //1
        points += this.getAlphaNumericChars();

        //2
        points += this.isTotalWithNoCents() ? 50 : 0;

        //3
        points += this.isMultipleOfQuarter() ? 25 : 0;

        //4
        int pairItems = this.getItems() != null ? this.items.size()/2 : 0;
        points += pairItems * 5;

        //5
        points += this.getItemPoints();

        //6
        points += this.isOddDate() ? 6 : 0;

        //7
        points += this.isPurchaseTimeBetweenTwoAndFourPM() ? 10 : 0;

        return points;
    }

    private int getItemPoints(){
        int itemPoints = 0;
        for (Item item : this.getItems()) {
            if(item.shortDescription.trim().length()%3 == 0) {
                itemPoints += Math.ceil(item.price * 0.2);
            }
        }
        return itemPoints;
    }


    private boolean isPurchaseTimeBetweenTwoAndFourPM(){
        if(!validTimeFormat()) return false;
        LocalTime startTime = LocalTime.of(14, 0);
        LocalTime endTime = LocalTime.of(16, 0);

        return !this.getPurchaseTime().isBefore(startTime) && this.getPurchaseTime().isBefore(endTime);
    }

    private boolean validTimeFormat() {
        try {
            return this.getPurchaseTime() != null;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private int getAlphaNumericChars(){
        int alphaNumericChars = 0;
        for(char c : this.getRetailer().toCharArray())
            if(Character.isLetterOrDigit(c))
                alphaNumericChars++;
        return alphaNumericChars;
    }

    private boolean isTotalWithNoCents(){
        if(this.getTotal() != null && this.getTotal() == 0.00) return false;
        return this.getTotal()!= null && this.getTotal() == Math.floor(this.getTotal()) && !Double.isInfinite(this.getTotal());
    }

    private boolean isMultipleOfQuarter(){
        if(this.getTotal() != null && this.getTotal() == 0.00) return false;
        return this.getTotal() != null && (this.getTotal() * 100) % 25 == 0;
    }

    private boolean isOddDate(){
        LocalDate date = this.getPurchaseDate().toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
        return date.getDayOfMonth() % 2 != 0;
    }


    public String getRetailer() {
        return retailer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public List<Item> getItems() {return items;}

    public Double getTotal() {
        return total;
    }

    public void setItems(List<Item> items) {this.items = items;}

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public void setPurchaseDate(Date purchaseDate) {this.purchaseDate = purchaseDate;}

    public void setPurchaseTime(LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setTotal(Double total) {this.total = total;}
}
