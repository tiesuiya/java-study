package org.lhpsn.ost.blockchain.example;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @version 1.0
 */
public class MainWallet {

    public static List<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static Wallet walletA;
    public static Wallet walletB;

    public static void main(String[] args) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        walletA = new Wallet();
        walletB = new Wallet();
        System.out.println("Private and public keys:");
        System.out.println(StringUtil.getStringFromKey(walletA.getPrivateKey()));
        System.out.println(StringUtil.getStringFromKey(walletA.getPublicKey()));
        // 创建交易
        Transaction transaction = new Transaction(walletA.getPublicKey(), walletB.getPublicKey(), 1, null);
        transaction.generateSignature(walletA.getPrivateKey());

        System.out.println("Is signature verified");
        System.out.println(transaction.verifiySignature());
    }
}
