package org.lhpsn.ost.xstream.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.lhpsn.ost.xstream.demo.common.CommonXmlHead;
import org.lhpsn.ost.xstream.demo.request.QueryTransferRequst;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
@XStreamAlias("CBHB")
public class QueryTransferRequestXml {

    @XStreamAlias("head")
    private CommonXmlHead head;

    @XStreamAlias("body")
    private QueryTransferRequst body;
}
