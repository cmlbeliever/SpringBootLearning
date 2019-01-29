package com.cml.learn.webflux;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.util.concurrent.EventExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.ipc.netty.options.ServerOptions;
import reactor.ipc.netty.resources.LoopResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication()
@Controller
@RequestMapping
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 自定义服务器线程配置信息
     *
     * @return
     */
    @Bean
    public ReactiveWebServerFactory reactiveWebServerFactory() {
        NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
        EventExecutor executor = new DefaultEventLoop(Executors.newWorkStealingPool());
        ChannelGroup channels = new DefaultChannelGroup(executor);
        factory.addServerCustomizers(builder -> builder.channelGroup(channels).loopResources(LoopResources.create("reactive-custom", 300, true)));
        return factory;
    }


//	@RequestMapping
//	@ResponseBody
//	public String index() {
//		return "hello world";
//	}
}
