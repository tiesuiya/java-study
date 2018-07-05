package org.lhpsn.common.util.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件查找帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public final class FileFinderUtil {

    private FileFinderUtil() {
    }

    /**
     * 查找文件静态方法
     *
     * @param path     查找路径
     * @param depth    查找深度
     * @param typeList 匹配后缀集合
     * @return 查找结果集合
     */
    public static List<File> find(String path, Integer depth, List<String> typeList) {
        return new FileFinder().findInner(path, depth, typeList);
    }

    /**
     * 文件查找类
     */
    private static class FileFinder {

        /**
         * 搜索深度
         */
        private Integer depth;

        /**
         * 文件类型
         */
        private List<String> typeList;

        /**
         * 查找结果集
         */
        private List<File> resultList;

        /**
         * 查找文件
         *
         * @param path     查找路径
         * @param depth    查找深度
         * @param typeList 匹配后缀集合
         * @return 查找结果集合
         */
        private List<File> findInner(String path, Integer depth, List<String> typeList) {
            this.resultList = new ArrayList<>();
            this.depth = depth;
            this.typeList = typeList == null ? new ArrayList<String>() : typeList;

            // 调用递归
            findRecursion(path, 1);
            return resultList;
        }

        /**
         * 查找文件递归
         *
         * @param path         查找路径
         * @param currentDepth 当前深度
         */
        private void findRecursion(String path, int currentDepth) {
            File file = new File(path);

            if (depth != null && currentDepth > depth) {
                return;
            }
            if (!file.exists()) {
                return;
            }
            if (!file.isDirectory()) {
                addFile(file);
                return;
            }

            // 已确保是文件夹，进行遍历
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File subFile : listFiles) {
                    String subFilePath = subFile.getPath();
                    // 文件夹
                    if (subFile.isDirectory()) {
                        // 递归
                        findRecursion(subFilePath, currentDepth + 1);
                    } else {
                        addFile(subFile);
                    }
                }
            }
        }

        /**
         * 添加文件
         *
         * @param file 文件
         */
        private void addFile(File file) {
            if (typeList.size() > 0) {
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (typeList.contains(suffix)) {
                    resultList.add(file);
                }
            } else {
                // 默认添加所有
                resultList.add(file);
            }
        }
    }
}
