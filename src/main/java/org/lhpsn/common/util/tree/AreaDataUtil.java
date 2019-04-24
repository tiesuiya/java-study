package org.lhpsn.common.util.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @date 2019-04-24 16:46
 */
public class AreaDataUtil {

    @Data
    @AllArgsConstructor
    public static class Area implements Treeable {
        private Integer id;
        private String name;
        private Integer parentId;

        @Override
        public String getTreeId() {
            return String.valueOf(id);
        }

        @Override
        public String getTreePid() {
            return String.valueOf(parentId);
        }

    }

    public static List<Area> getAreaData() throws Exception {
        List<Area> areas = new ArrayList<>();
        File file = new File(AreaDataUtil.class.getResource("/file/AreaData.txt").getPath());
        try (InputStream in = new FileInputStream(file)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s = br.readLine()) != null) {
                if (!s.startsWith("#")) {
                    String[] lineData = s.split(",");
                    areas.add(new Area(Integer.valueOf(lineData[0]), lineData[1], Integer.valueOf(lineData[2])));
                }
            }
            br.close();
        }
        return areas;
    }

}
