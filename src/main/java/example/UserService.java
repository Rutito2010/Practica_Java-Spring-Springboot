package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
@Autowired
    NotificacionService notificacionService ;

    public UserService(NotificacionService notificacionService){
        this.notificacionService = notificacionService ;
    }
}
