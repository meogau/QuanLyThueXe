package API;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionAPI {
    private static CloseableHttpClient httpClient;

    public static JSONObject processTransaction(TransactionRequest transactionRequest) throws IOException {
        httpClient = HttpClients.createDefault();

        HttpPatch httpPatch = new HttpPatch(Config.BASE_URL + "/api/card/processTransaction");
        String bodyRequest = getBodyRequest(transactionRequest);
        httpPatch.setEntity(new StringEntity(bodyRequest, ContentType.APPLICATION_JSON));

        HttpResponse httpResponse = httpClient.execute(httpPatch);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }

        //Now pull back the response object
        HttpEntity httpEntity = httpResponse.getEntity();
        JSONObject jsonResult = new JSONObject(EntityUtils.toString(httpEntity));
        // TODO: continue something
        return jsonResult;
    }

    private static String getBodyRequest(TransactionRequest transactionRequest){
        JSONObject transaction = getJSONTransaction(transactionRequest);
        String hashCode = getHashCode(getJsonToHashCode(transaction).toString());
        JSONObject bodyRequest = new JSONObject();

        bodyRequest.put("version", Config.API_VERSION);
        bodyRequest.put("transaction", transaction);
        bodyRequest.put("appCode", Config.APP_CODE);
        bodyRequest.put("hashCode", hashCode);
        return bodyRequest.toString();
    }

    private static JSONObject getJSONTransaction(TransactionRequest transactionRequest) {
        JSONObject obj = new JSONObject();
        obj.put("command", transactionRequest.getCommand());
        obj.put("cardCode", transactionRequest.getCardCode());
        obj.put("owner", transactionRequest.getOwner());
        obj.put("cvvCode", transactionRequest.getCvvCode());
        obj.put("dateExpired", transactionRequest.getDateExpired());
        obj.put("transactionContent", transactionRequest.getTransactionContent());
        obj.put("amount", transactionRequest.getAmount());
        obj.put("createdAt", format(transactionRequest.getCreateAt()));
        return obj;
    }

    private static String getHashCode(String jsonString) {
        return DigestUtils.md5Hex(jsonString);
    }

    private static JSONObject getJsonToHashCode(JSONObject jsonTransaction) {
        JSONObject obj = new JSONObject();
        obj.put("secretKey", Config.SECRET_KEY);
        obj.put("transaction", jsonTransaction);
        return obj;
    }

    private static String format(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = formatter.format(date);
        System.out.println(strDate);
        return strDate;
    }

}
