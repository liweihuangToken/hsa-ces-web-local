package cn.hsa.ces.mq.service.impl;

import cn.hsa.ces.mq.dto.MsgDTO;
import cn.hsa.ces.mq.service.MqProducerService;
import cn.hsa.hsaf.core.mq.MQMessage;
import cn.hsa.hsaf.core.mq.MQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 消息队列 生产者
 *
 * @author cz-lingang
 */
@Service
public class MqProducerServiceImpl implements MqProducerService {

    private final Logger log = LoggerFactory.getLogger(MqProducerServiceImpl.class);

    @Value("${mq.topic.string}")
    private String stringTopic;

    @Value("${mq.topic.dto}")
    private String dtoTopic;

    @Autowired
    private MQProducer mqProducer;

    @Override
    public boolean sendMsgString(String msgStr) {

        MQMessage<String> mqMessage = new MQMessage<String>();
        mqMessage.setTopic(stringTopic);
        mqMessage.setContent(msgStr);

        return execute(mqMessage);
    }

    @Override
    public boolean sendMsgDTO(MsgDTO msgDTO) {

        MQMessage<MsgDTO> mqMessage = new MQMessage<MsgDTO>();
        mqMessage.setTopic(dtoTopic);
        mqMessage.setContent(msgDTO);

        return execute(mqMessage);
    }

    private boolean execute(MQMessage<?> mqMessage) {
        if (mqProducer.send(mqMessage)) {
            return true;
        }
        log.error("DEMO发送消息队列，发送失败，消息主题：{}，消息内容：{}。", mqMessage.getTopic(), mqMessage);
        return false;
    }
}
