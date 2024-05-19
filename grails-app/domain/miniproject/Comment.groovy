package miniproject

class Comment {
    String description
    User createBy
    Date createAt
    Comment parent
    static constraints = {
        parent nullable: true
    }
}
