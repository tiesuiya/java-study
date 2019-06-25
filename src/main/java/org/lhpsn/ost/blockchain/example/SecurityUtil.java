package org.lhpsn.ost.blockchain.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class SecurityUtil {

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
}