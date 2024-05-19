package miniproject

class UrlMappings {

    static mappings = {

        group "/admin", {
            "/dashboard/$action?/$id?(.$format)?"(controller: "dashboard")
            "/comment/$action?/$id?(.$format)?"(controller: "comment")
        }

        // Springsecurity
        "/login/$action?"(controller: "login") { lang = 'en' }
        "/logout"(controller: "logout") { lang = 'en' }

//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
