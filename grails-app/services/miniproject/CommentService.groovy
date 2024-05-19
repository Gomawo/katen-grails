package miniproject

import grails.gorm.transactions.Transactional
import miniproject.models.ReqComment

@Transactional
class CommentService {

    Comment save(ReqComment reqComment, User user) {
        Comment parent = Comment.findById(reqComment.parent_id)
        Comment comment = new Comment(
                description: reqComment.description,
                createBy: user,
                parent: parent,
                createAt: new Date()
        )

        comment.validate()

        if (!comment.hasErrors()) {
            comment.save(flush:true)
        }

        return comment
    }
}