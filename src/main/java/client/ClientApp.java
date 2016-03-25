package client; /**
 * Created by Administrator on 2015/8/13.
 */

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;

class ClientApp implements Bootable {
    static String serverName = "";
    static String ip ="";
    static String port = "";
    static String actorServerName ="";
    static String params ="";

    ActorSystem system;
    ActorRef serverActor;

    ClientApp(String serverName,String ip,String port,String actorServerName,String params){
        //方式一 直接调用
//        ActorSystem.create(ClientActor.AkkaSystemName, ConfigFactory.load().getConfig("client")).
//                actorFor("akka://serName@10.68.14.43:8888/user/serverActorName").tell("hello,3q I'm client ");

        //方式二 提交客户端actor用于回调
        system = ActorSystem.create(ClientActor.AkkaSystemName, ConfigFactory.load().getConfig("client"));
        ActorRef client = system.actorOf(new Props(ClientActor.class), "clientActorName");
//        system.actorFor("akka://serName@10.68.14.139:8888/user/serverActorName").tell("hello,3q I'm client ",client);
        system.actorFor("akka://"+serverName+"@"+ip+":"+port+"/user/"+actorServerName+"").tell(params,client);

    }

    public void startup() {

    }

    public void shutdown() {
        system.shutdown();
    }

}
