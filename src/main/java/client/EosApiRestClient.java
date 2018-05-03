package client;

import client.domain.request.chain.RequiredKeysRequest;
import client.domain.request.chain.TransactionRequest;
import client.domain.request.wallet.SignTransactionRequest;
import client.domain.response.chain.*;
import client.domain.response.wallet.SignTransaction;

import java.util.List;

public interface EosApiRestClient {

    ChainInfo getChainInfo();

    Block getBlock(String blockNumberOrId);

    Account getAccount(String accountName);

    Code getCode(String accountName);

    TableRow getTableRows(String scope, String code, String table, Boolean json, int lowerBound, int upperBound, int limit);

    AbiBinJson apiBinToJson(String code, String action, String binargs);

    void pushTransactions(List<TransactionRequest> transactionRequests);

    RequiredKeys getRequiredKeys(RequiredKeysRequest requiredKeysRequests);

    String createWallet(String walletName);

    void openWallet(String walletName);

    void lockWallet(String walletName);

    void lockAllWallets();

    void unlockWallet(String walletName, String walletPassword);

    void importKeyIntoWallet(String walletName, String walletKey);

    List<String> listWallets();

    List<String> listKeys();

    List<String> getPublicKeys();

    SignTransaction signTransaction(SignTransactionRequest signTransactionRequest);

    void setWalletTimeout(Integer timeout);
}
