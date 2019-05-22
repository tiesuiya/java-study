package org.lhpsn.ost.xstream.demo.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
public class QueryTransferResponse {

    @XStreamAlias("TransList")
    private List<QueryTransferResponseRecord> transList;

    @XStreamAlias("IsCertExpired")
    private String isCertExpired;
}
