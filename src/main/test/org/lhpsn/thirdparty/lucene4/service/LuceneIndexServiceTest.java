package org.lhpsn.thirdparty.lucene4.service;

import org.junit.Test;
import org.lhpsn.thirdparty.lucene4.dto.IndexDTO;
import org.lhpsn.thirdparty.lucene4.dto.IndexScheduleDTO;
import org.lhpsn.thirdparty.lucene4.dto.SearchResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * lucene测试
 *
 * @author lh
 * @since 1.0.0
 */
public class LuceneIndexServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuceneIndexServiceTest.class);

    @Test
    public void testRefreshAndGetSchedule() throws Exception {
        LuceneIndexService luceneIndexService = new LuceneIndexServiceImpl();
        LOGGER.debug("index begin");

        luceneIndexService.syncRefreshAllIndex("/");

        IndexScheduleDTO dto = luceneIndexService.getSyncRefreshSchedule();
        List<IndexScheduleDTO> resultList = new ArrayList<>();
        while (dto.getStatus().equals(IndexScheduleDTO.StatusEnum.RUNNING.getState())) {
            Thread.sleep(1000);
            resultList.add(dto);
        }
        LOGGER.debug("进度对象：{}", resultList);
        LOGGER.debug("index done");
    }


    @Test
    public void testDoSearcher() {
        LuceneIndexService luceneIndexService = new LuceneIndexServiceImpl();

        SearchResultDTO<IndexDTO> result = luceneIndexService.doSearcher("分", 1, 1000000);
        LOGGER.debug("检索结果：{}", result);
    }
}