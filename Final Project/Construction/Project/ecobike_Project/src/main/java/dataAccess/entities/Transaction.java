package dataAccess.entities;

public class Transaction {
   private int id;
   private int cardId;
   private float amount;
   private String command;

    public String getType() {
        return command;
    }

    public void setType(String command) {
        this.command = command;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
