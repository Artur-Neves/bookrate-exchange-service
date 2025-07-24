package br.com.neves.exchange_service.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class InstanceInformationService implements ApplicationListener<WebServerInitializedEvent> {

    private String port;

    @Value("${HOSTNAME:LOCAL}")
    private String hostName;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = String.valueOf(event.getWebServer().getPort());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }

    public String getPort() {
        return port;
    }

    public String getHostName() {
        return hostName.substring(hostName.length()-5);
    }
}
