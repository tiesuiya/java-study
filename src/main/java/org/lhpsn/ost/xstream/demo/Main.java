package org.lhpsn.ost.xstream.demo;

import com.alibaba.fastjson.JSON;
import org.lhpsn.ost.xstream.demo.common.CommonXmlHead;
import org.lhpsn.ost.xstream.demo.request.QueryTransferRequst;

/**
 * @author tsy
 * @date 2019-05-21 17:32
 */
public class Main {

    // xstream实现复杂的xml和对象之间的转换示例，由于xstream不支持泛型、继承，xml转对象的过程非常尴尬
    public static void main(String[] args) {
        objectToXml();
        xmlToObject();
    }

    private static void xmlToObject() {
        String rsp = "<?xml version=\"1.0\" encoding=\"GBK\"?><CBHB><head><Title>WW888</Title></head><body><TransList><Record><Amt>200.00</Amt><No>001</No></Record><Record><Amt>2200.00</Amt><No>002</No></Record></TransList><IsCertExpired></IsCertExpired></body></CBHB>";
        QueryTransferResponseXml obj = XmlUtils.fromXML(rsp, QueryTransferResponseXml.class);
        System.out.println(JSON.toJSONString(obj));
    }

    private static void objectToXml() {
        CommonXmlHead requestHead = new CommonXmlHead();
        requestHead.setTitle("Hello");
        QueryTransferRequst requestBody = new QueryTransferRequst();
        requestBody.setAcctNo("2000010003");
        QueryTransferRequestXml request = new QueryTransferRequestXml();
        request.setHead(requestHead);
        request.setBody(requestBody);
        String xml = XmlUtils.toXML(request);
        System.out.println(xml);
    }
}
