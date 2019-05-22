package org.lhpsn.ost.xstream.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.lhpsn.ost.xstream.demo.common.CommonXmlHead;
import org.lhpsn.ost.xstream.demo.response.QueryTransferResponse;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
@XStreamAlias("CBHB")
public class QueryTransferResponseXml {

    @XStreamAlias("head")
    private CommonXmlHead head;

    @XStreamAlias("body")
    private QueryTransferResponse body;
}
