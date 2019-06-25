package org.lhpsn.ost.blockchain.example;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.List;

public class StringUtil {

    //Applies Sha256 to a string and returns the result.
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isChainValid(List<Block> blockChain, int difficulty) {
        if (blockChain == null || blockChain.isEmpty()) {
            System.err.println("空的区块链");
            return false;
        }
        Block genesisBlock = blockChain.get(0);
        if (!genesisBlock.calculateHash().equals(genesisBlock.getHash())) {
            System.err.println("头block校验失败");
            return false;
        }
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        for (int i = 1; i < blockChain.size(); i++) {
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);

            if (!currentBlock.calculateHash().equals(currentBlock.getHash())) {
                System.err.println("当前block校验失败");
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.err.println("上级block校验失败");
                return false;
            }

            if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
                // This block hasn't been mined
                System.err.println("该区块尚未开采");
                return false;
            }
        }
        return true;
    }

    // 交易签名
    public static byte[] applyECDSASig(PrivateKey privateKey, String input) {
        Signature dsa;
        byte[] output = new byte[0];
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(privateKey);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            byte[] realSig = dsa.sign();
            output = realSig;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    //Verifies a String signature 交易验签
    public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(publicKey);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}