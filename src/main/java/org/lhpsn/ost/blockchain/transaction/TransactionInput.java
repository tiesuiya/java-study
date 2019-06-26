package org.lhpsn.ost.blockchain.transaction;

import lombok.Data;

/**
 * @author tsy
 * @version 1.0
 */
@Data
public class TransactionInput {
    private String transactionOutputId;
    private TransactionOutput utxo;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}
