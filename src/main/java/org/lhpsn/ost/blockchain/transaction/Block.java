package org.lhpsn.ost.blockchain.transaction;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 区块
 *
 * @author tsy 教材来自https://github.com/longfeizheng/blockchain-java
 * @date 2019-06-25 12:46
 */
@Data
public class Block {
    private String hash;
    private String previousHash;
    private String merkleRoot;
    private long timeStamp;
    private int nonce;
    private List<Transaction> transactions = new ArrayList<>(); //our data will be a simple message.


    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    /**
     * 计算hash
     *
     * @return
     */
    public String calculateHash() {
        return StringUtil.applySha256(previousHash + timeStamp + nonce + merkleRoot);
    }

    /**
     * 挖矿
     *
     * @param difficulty
     */
    public void mineBlock(int difficulty) {
        merkleRoot = StringUtil.getMerkleRoot(transactions);
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
//            System.out.println("\tBlock Mined!!! : " + hash);
        }
    }

    //Add transactions to this block
    public boolean addTransaction(Transaction transaction) {
        //process transaction and check if valid, unless block is genesis block then ignore.
        if (transaction == null) return false;
        if ((!"0".equals(previousHash))) {
            if ((!transaction.processTransaction())) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }
        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }
}
