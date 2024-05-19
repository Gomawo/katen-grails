package miniproject

import grails.gorm.transactions.Transactional
import miniproject.models.ReqComment

@Transactional
class CommentInitService {

    CommentService commentService

    def init() {
        User admin = User.findByUsername("admin")
        ReqComment comment1 = new ReqComment(
                description: "as"
        )

        commentService.save(comment1, admin)

        ReqComment comment2 = new ReqComment(
                description: "Article",
                parent_id: 1
        )

        commentService.save(comment2, admin)

        ReqComment comment3 = new ReqComment(
                description: "Profile",
                parent_id: 1
        )

        commentService.save(comment3, admin)
    }
}

