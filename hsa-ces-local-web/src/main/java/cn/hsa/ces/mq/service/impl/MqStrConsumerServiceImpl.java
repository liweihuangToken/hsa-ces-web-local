package cn.hsa.ces.mq.service.impl;

import cn.hsa.hsaf.core.mq.MQBusinessHandler;
import cn.hsa.hsaf.core.mq.MQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 消息队列业务处理对象
 *
 * @author cz-lingang
 */
@Service("mqStrConsumerService")
public class MqStrConsumerServiceImpl implements MQBusinessHandler {

    private final Logger log = LoggerFactory.getLogger(MqStrConsumerServiceImpl.class);

    @Override
    public boolean doBusiness(MQMessage<?> mqMessage) {
        try {
            return true;
        } catch (Exception e) {
//            log.error("DEMO接收消息队列，业务处理失败.", e);
            return false;
        }
    }
}
