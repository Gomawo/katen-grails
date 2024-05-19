package miniproject

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import miniproject.models.ReqComment

@Secured('ROLE_ADMIN')
class CommentController {

    CommentService commentService
    SpringSecurityService springSecurityService

    /**
     * commentId = 1
     * description = bacot aja lu
     * @param reqComment
     */

    def index() {
        List<Comment> comments = Comment.findAll()

        return [commentList:comments]
    }

    def show(Comment comment) {
        if (!comment) render view: "/notFound"
        [comment: comment]
    }

    def save(ReqComment reqComment) {
        User user = springSecurityService.currentUser as User
        Comment comment = commentService.save(reqComment, user)

        if (comment.hasErrors()) {
            render view: "create", model: [comment: comment]
            return
        }

        redirect(action: "show", params: [id:comment.id])
    }
}
