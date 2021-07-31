package OOP.core.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    /**
     * DL을 통해 의존성 주입
     */
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;

    public void logic(String id) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
