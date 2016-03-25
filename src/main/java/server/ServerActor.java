package server;
/**
 * Created by Administrator on 2015/8/13.
 */

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/** 服务器端Actor */
class ServerActor extends UntypedActor {
    static final String AkkaSystemName = "serName";
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) {
        log.debug("server收到消息----${message}----self:${getSelf()},sender:${getSender()}");
        System.out.println("收到客户端的消息: "+message);
        String msg = "服务端已收到消息: "+message;
        getSender().tell(msg,self());//给客户端actor发送消息
    }

}

