package org.lhpsn.thirdparty.lucene4.service;

import org.junit.Test;
import org.lhpsn.thirdparty.lucene4.dto.IndexDTO;
import org.lhpsn.thirdparty.lucene4.dto.IndexScheduleDTO;
import org.lhpsn.thirdparty.lucene4.dto.SearchResultDTO;

/**
 * lucene测试
 *
 * @author lh
 * @since 1.0.0
 */
public class LuceneIndexServiceTest {

    @Test
    public void testRefreshAndGetSchedule() throws Exception {
        LuceneIndexService luceneIndexService = new LuceneIndexServiceImpl();

        System.out.println("index begin");

        luceneIndexService.syncRefreshAllIndex("/");

        IndexScheduleDTO dto = luceneIndexService.getSyncRefreshSchedule();
        while (dto.getStatus().equals(IndexScheduleDTO.StatusEnum.RUNNING.getState())) {
            System.out.println(dto);
            Thread.sleep(1000);
        }

        System.out.println("index done");
    }


    @Test
    public void testDoSearcher() {
        LuceneIndexService luceneIndexService = new LuceneIndexServiceImpl();

        SearchResultDTO<IndexDTO> result = luceneIndexService.doSearcher("计算", 1, 100);
        if (null != result.getDatas() && result.getDatas().size() > 0) {
            System.out.println(result.getDatas().size());
            for (Object service : result.getDatas()) {
                IndexDTO searchFile = (IndexDTO) service;
                System.out.println(searchFile);
            }
        }
    }
}