package org.lhpsn.ost.blockchain.example;

import lombok.Data;

import java.util.Date;

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
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
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
        return StringUtil.applySha256(previousHash + timeStamp + nonce + data);
    }

    /**
     * 挖矿
     *
     * @param difficulty
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
            System.out.println("\tBlock Mined!!! : " + hash);
        }
    }
}
