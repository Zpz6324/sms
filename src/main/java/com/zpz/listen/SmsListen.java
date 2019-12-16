package com.zpz.listen;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zpz.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Random;

/**
 * All rights Reserved, Designed By www.Zpz.com
 * <p>title:com.zpz.listen</p>
 * <p>ClassName:SmsListen</p>
 * <p>Description:TODO(请用一句话描述这个类的作用)</p>
 * <p>Compony:Info4z</p>
 * author:Zpz
 * date:2019/12/3 0003
 * version:1.0
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class SmsListen {
    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "youlexuan_sms")
    public void sendSms(Map<String, String> map) {

        try {
            SendSmsResponse resp = smsUtil.sendSms(map.get("phone"), map.get("sign"), map.get("template"), map.get("code"));

            System.out.println(resp.getCode());
            System.out.println(resp.getMessage());
            System.out.println();

        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

}
