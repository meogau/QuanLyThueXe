package API;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionRequest {

    private String CardCode;
    private String Owner;
    private String CvvCode;
    private String dateExpired;
    private String transactionContent;
    private BigDecimal amount;
    private Date createAt;
    private String command;


    public String getCardCode() {
        return CardCode;
    }


    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }


    public String getOwner() {
        return Owner;
    }


    public void setOwner(String owner) {
        Owner = owner;
    }


    public String getCvvCode() {
        return CvvCode;
    }

    public void setCvvCode(String cvvCode) {
        CvvCode = cvvCode;
    }

    public String getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(String dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
