package com.cd.ftp;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface FileWriterGateway {

    public void write(@Header("file-name") String fileName, @Header("remote-directory") String remoteDir, @Payload String message);
}
