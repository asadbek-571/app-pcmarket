package uz.pdp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.entity.User;


@Projection(types = User.class)
public interface CustomUser {

     Long getId();

     String getPhoneNumber();

     String getEmail();

     String getAddress();

     boolean getActive();

}
