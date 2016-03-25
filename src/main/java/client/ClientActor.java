package client; /**
 * Created by Administrator on 2015/8/13.
 */

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

class ClientActor extends UntypedActor {
    static final String AkkaSystemName = "clientName";
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) {
        log.debug("server收到消息----${message}----self:${getSelf()},sender:${getSender()}");
        System.out.println("收到服务器端发回来的消息：" + message.toString());
        //getSender().tell(message,null);//给服务端actor发送消息
    }

}

