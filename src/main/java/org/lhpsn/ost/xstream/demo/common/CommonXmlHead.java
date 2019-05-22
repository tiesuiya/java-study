package org.lhpsn.ost.xstream.demo.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
@Data
public class CommonXmlHead {

    @XStreamAlias("Title")
    private String title;
}
