package com.jms.xmltopdf.eventhandler;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class CustomValidationEventHandler implements ValidationEventHandler {

    public boolean handleEvent(ValidationEvent evt) {
        System.out.println("Event Info: "+evt);
        if(evt.getMessage().toLowerCase().contains("unexpected element"))
            return true;
        return false;
    }

}
