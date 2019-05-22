package org.lhpsn.ost.xstream.demo.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
@XStreamAlias("Record")
public class QueryTransferResponseRecord {

    @XStreamAlias("No")
    private String no;

    @XStreamAlias("Amt")
    private String amt;
}
