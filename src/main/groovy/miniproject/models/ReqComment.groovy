package miniproject.models

import grails.validation.Validateable
import org.hibernate.annotations.Parent

class ReqComment implements Validateable{
    Long parent_id
    String description


    static constraints = {
        parent_id nullable: true
        description nullable: true
    }
}

