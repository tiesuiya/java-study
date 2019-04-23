package org.lhpsn.common.util.tree.generator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author tsy
 * @date 2019-04-23 11:27
 */
public class Main {

    @Data
    @AllArgsConstructor
    static class Area implements Treeable {
        private Integer id;
        private String name;
        private Integer parentId;

        @Override
        public Object getTreeId() {
            return id;
        }

        @Override
        public Object getTreePid() {
            return parentId;
        }

        @Override
        public int compareTo(Object o) {
            Area area = (Area) o;
            return id - area.getId();
        }
    }

    public static void main(String[] args) {
        List<TreeNode<Area>> tree = TreeUtils.generate(Arrays.asList(Areas), 0);
        TreeUtils.printTree(tree);
    }

    private static Area[] Areas = {new Area(510112, "龙泉驿区", 510100), new Area(510113, "青白江区", 510100), new Area(510114, "新都区", 510100), new Area(510115, "温江区", 510100), new Area(510121, "金堂县", 510100), new Area(510122, "双流县", 510100), new Area(510124, "郫县", 510100), new Area(510129, "大邑县", 510100), new Area(510131, "蒲江县", 510100), new Area(510504, "龙马潭区", 510500), new Area(510521, "泸县", 510500), new Area(510402, "东区", 510400), new Area(510403, "西区", 510400), new Area(510411, "仁和区", 510400), new Area(510421, "米易县", 510400), new Area(510422, "盐边县", 510400), new Area(510500, "泸州市", 510000), new Area(510501, "市辖区", 510500), new Area(510502, "江阳区", 510500), new Area(510503, "纳溪区", 510500), new Area(510822, "青川县", 510800), new Area(510823, "剑阁县", 510800), new Area(510824, "苍溪县", 510800), new Area(510900, "遂宁市", 510000), new Area(510901, "市辖区", 510900), new Area(510903, "船山区", 510900), new Area(510904, "安居区", 510900), new Area(510921, "蓬溪县", 510900), new Area(510922, "射洪县", 510900), new Area(510923, "大英县", 510900), new Area(511000, "内江市", 510000), new Area(511001, "市辖区", 511000), new Area(511002, "市中区", 511000), new Area(511011, "东兴区", 511000), new Area(511024, "威远县", 511000), new Area(511025, "资中县", 511000), new Area(511028, "隆昌县", 511000), new Area(511100, "乐山市", 510000), new Area(511101, "市辖区", 511100), new Area(511102, "市中区", 511100), new Area(511111, "沙湾区", 511100), new Area(511112, "五通桥区", 511100), new Area(511113, "金口河区", 511100), new Area(510100, "成都市", 510000), new Area(510101, "市辖区", 510100), new Area(510104, "锦江区", 510100), new Area(510105, "青羊区", 510100), new Area(510106, "金牛区", 510100), new Area(510107, "武侯区", 510100), new Area(510681, "广汉市", 510700), new Area(510682, "什邡市", 510700), new Area(510683, "绵竹市", 510700), new Area(510700, "绵阳市", 510000), new Area(510701, "市辖区", 510700), new Area(510703, "涪城区", 510700), new Area(510704, "游仙区", 510700), new Area(510722, "三台县", 510700), new Area(510723, "盐亭县", 510700), new Area(510724, "安县", 510700), new Area(510725, "梓潼县", 510700), new Area(510522, "合江县", 510500), new Area(510524, "叙永县", 510500), new Area(510525, "古蔺县", 510500), new Area(510600, "德阳市", 510000), new Area(510601, "市辖区", 510600), new Area(510603, "旌阳区", 510600), new Area(510623, "中江县", 510600), new Area(510626, "罗江县", 510600), new Area(511126, "夹江县", 511100), new Area(511129, "沐川县", 511100), new Area(511132, "峨边彝族自治县", 511100), new Area(511133, "马边彝族自治县", 511100), new Area(511181, "峨眉山市", 511200), new Area(511300, "南充市", 510000), new Area(511301, "市辖区", 511300), new Area(511302, "顺庆区", 511300), new Area(511303, "高坪区", 511300), new Area(511304, "嘉陵区", 511300), new Area(511321, "南部县", 511300), new Area(513332, "石渠县", 513300), new Area(513333, "色达县", 513300), new Area(513334, "理塘县", 513300), new Area(513335, "巴塘县", 513300), new Area(513336, "乡城县", 513300), new Area(513337, "稻城县", 513300), new Area(513338, "得荣县", 513300), new Area(513400, "凉山彝族自治州", 510000), new Area(513401, "西昌市", 513400), new Area(513422, "木里藏族自治县", 513400), new Area(513423, "盐源县", 513400), new Area(513424, "德昌县", 513400), new Area(513425, "会理县", 513400), new Area(513426, "会东县", 513400), new Area(513427, "宁南县", 513400), new Area(513428, "普格县", 513400), new Area(512002, "雁江区", 512000), new Area(512021, "安岳县", 512000), new Area(512022, "乐至县", 512000), new Area(512081, "简阳市", 512100), new Area(513200, "阿坝藏族羌族自治州", 510000), new Area(513221, "汶川县", 513200), new Area(513222, "理县", 513200), new Area(513223, "茂县", 513200), new Area(513224, "松潘县", 513200), new Area(513225, "九寨沟县", 513200), new Area(513226, "金川县", 513200), new Area(513227, "小金县", 513200), new Area(513429, "布拖县", 513400), new Area(513430, "金阳县", 513400), new Area(511322, "营山县", 511300), new Area(511323, "蓬安县", 511300), new Area(511324, "仪陇县", 511300), new Area(511325, "西充县", 511300), new Area(510000, "四川省", 0), new Area(510812, "朝天区", 510800), new Area(510821, "旺苍县", 510800), new Area(510132, "新津县", 510100), new Area(510181, "都江堰市", 510200), new Area(510182, "彭州市", 510200), new Area(510183, "邛崃市", 510200), new Area(510184, "崇州市", 510200), new Area(510108, "成华区", 510100), new Area(510300, "自贡市", 510000), new Area(510301, "市辖区", 510300), new Area(510302, "自流井区", 510300), new Area(510303, "贡井区", 510300), new Area(510304, "大安区", 510300), new Area(510311, "沿滩区", 510300), new Area(510321, "荣县", 510300), new Area(510322, "富顺县", 510300), new Area(510400, "攀枝花市", 510000), new Area(510401, "市辖区", 510400), new Area(510726, "北川羌族自治县", 510700), new Area(510727, "平武县", 510700), new Area(510781, "江油市", 510800), new Area(510800, "广元市", 510000), new Area(510801, "市辖区", 510800), new Area(510802, "利州区", 510800), new Area(510811, "元坝区", 510800), new Area(511123, "犍为县", 511100), new Area(511124, "井研县", 511100), new Area(511381, "阆中市", 511400), new Area(511400, "眉山市", 510000), new Area(511401, "市辖区", 511400), new Area(511402, "东坡区", 511400), new Area(511421, "仁寿县", 511400), new Area(511422, "彭山县", 511400), new Area(511423, "洪雅县", 511400), new Area(511424, "丹棱县", 511400), new Area(511425, "青神县", 511400), new Area(511500, "宜宾市", 510000), new Area(511501, "市辖区", 511500), new Area(511502, "翠屏区", 511500), new Area(511503, "南溪区", 511500), new Area(511521, "宜宾县", 511500), new Area(511523, "江安县", 511500), new Area(511524, "长宁县", 511500), new Area(511525, "高县", 511500), new Area(511526, "珙县", 511500), new Area(511527, "筠连县", 511500), new Area(511528, "兴文县", 511500), new Area(511529, "屏山县", 511500), new Area(511600, "广安市", 510000), new Area(511601, "市辖区", 511600), new Area(511602, "广安区", 511600), new Area(511621, "岳池县", 511600), new Area(511622, "武胜县", 511600), new Area(511623, "邻水县", 511600), new Area(511681, "华蓥市", 511700), new Area(511700, "达州市", 510000), new Area(511701, "市辖区", 511700), new Area(511702, "通川区", 511700), new Area(511721, "达县", 511700), new Area(511722, "宣汉县", 511700), new Area(511723, "开江县", 511700), new Area(511724, "大竹县", 511700), new Area(511725, "渠县", 511700), new Area(511781, "万源市", 511800), new Area(511800, "雅安市", 510000), new Area(511801, "市辖区", 511800), new Area(511802, "雨城区", 511800), new Area(511803, "名山区", 511800), new Area(513327, "炉霍县", 513300), new Area(513328, "甘孜县", 513300), new Area(513329, "新龙县", 513300), new Area(513330, "德格县", 513300), new Area(513331, "白玉县", 513300), new Area(513431, "昭觉县", 513400), new Area(513432, "喜德县", 513400), new Area(513433, "冕宁县", 513400), new Area(513434, "越西县", 513400), new Area(513435, "甘洛县", 513400), new Area(513436, "美姑县", 513400), new Area(513437, "雷波县", 513400), new Area(511822, "荥经县", 511800), new Area(511823, "汉源县", 511800), new Area(511824, "石棉县", 511800), new Area(511825, "天全县", 511800), new Area(511826, "芦山县", 511800), new Area(511827, "宝兴县", 511800), new Area(511900, "巴中市", 510000), new Area(511901, "市辖区", 511900), new Area(511902, "巴州区", 511900), new Area(511921, "通江县", 511900), new Area(511922, "南江县", 511900), new Area(511923, "平昌县", 511900), new Area(512000, "资阳市", 510000), new Area(512001, "市辖区", 512000), new Area(513228, "黑水县", 513200), new Area(513229, "马尔康县", 513200), new Area(513230, "壤塘县", 513200), new Area(513231, "阿坝县", 513200), new Area(513232, "若尔盖县", 513200), new Area(513233, "红原县", 513200), new Area(513300, "甘孜藏族自治州", 510000), new Area(513321, "康定县", 513300), new Area(513322, "泸定县", 513300), new Area(513323, "丹巴县", 513300), new Area(513324, "九龙县", 513300), new Area(513325, "雅江县", 513300), new Area(513326, "道孚县", 513300)};
}
