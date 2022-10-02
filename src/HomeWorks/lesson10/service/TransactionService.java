package HomeWorks.lesson10.service;

import HomeWorks.lesson10.entity.Client;
import HomeWorks.lesson10.util.Helper;

public class TransactionService {
    public void sendMoney(Client client, String clientAccountID) {
        Helper.checkUsers(client.getClientAccountID(),clientAccountID);
    }
}
