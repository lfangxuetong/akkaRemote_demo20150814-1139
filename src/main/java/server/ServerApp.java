package server;
/**
 * Created by Administrator on 2015/8/13.
 */

import akka.actor.*;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;
import akka.remote.RemoteScope;

/** 启动ActorSystem  */
class ServerApp implements Bootable {
    ActorSystem system;
    ActorRef serverActor;

    ServerApp() {
        system = ActorSystem.create(ServerActor.AkkaSystemName, ConfigFactory.load().getConfig("server"));
        serverActor = system.actorOf(new Props(ServerActor.class), "serverActorName");
        System.out.println("serverActor.path"+serverActor.path());

        //发布一个远程对象到远程客户端的机器上
        //Address addr = new Address("akka", ServerActor.AkkaSystemName, "10.68.14.49", 8888);
        //serverActor = system.actorOf(new Props(ServerActor.class).withDeploy(new Deploy(new RemoteScope(addr))), "simple");
        //System.out.println("serverActor.path = "+serverActor.path());
    }

    public void startup() {

    }

    public void shutdown() {
        system.shutdown();
    }

}
