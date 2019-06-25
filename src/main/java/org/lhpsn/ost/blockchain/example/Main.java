package org.lhpsn.ost.blockchain.example;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @date 2019-06-25 12:53
 */
public class Main {

    public static int difficulty = 4;

    public static void main(String[] args) {
        List<Block> blockChain = new ArrayList<>();

        Block genesisBlock = new Block("Hello World!", "0");
        blockChain.add(genesisBlock);
        blockChain.get(blockChain.size() - 1).mineBlock(difficulty);
        System.out.println("Hash for block 1:" + genesisBlock.getHash());

        Block secondBlock = new Block("Hi! I'm second block!", genesisBlock.getHash());
        blockChain.add(secondBlock);
        blockChain.get(blockChain.size() - 1).mineBlock(difficulty);
        System.out.println("Hash for block 2:" + secondBlock.getHash());

        Block thirdBlock = new Block("Hi! I'm third block!", secondBlock.getHash());
        blockChain.add(thirdBlock);
        blockChain.get(blockChain.size() - 1).mineBlock(difficulty);
        System.out.println("Hash for block 3:" + thirdBlock.getHash());

        // blockChain.get(0).setData("change it!");

        System.out.println("BlockChain is valid? " + SecurityUtil.isChainValid(blockChain, difficulty));

        System.out.println(JSON.toJSONString(blockChain));
    }
}
