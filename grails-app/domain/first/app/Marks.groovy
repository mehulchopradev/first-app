package first.app

class Marks {

    Float physics

    Float chemistry

    Float maths

    Float quant

    Float verbal

    // bidirectional one to one rel between the entities
    static belongsTo = [user: User] // owned entity

    static constraints = {
    }
}
