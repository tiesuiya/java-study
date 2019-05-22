package org.lhpsn.ost.xstream.demo.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
public class QueryTransferRequst {

    @XStreamAlias("QryBankSeqno")
    private String qryBankSeqno;

    @XStreamAlias("AcctNo")
    private String acctNo;
}
