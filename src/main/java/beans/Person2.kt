package beans

data class Person2 (var id:Int, var name:String, var age:Int) {
    constructor(s:String) : this(0,"",0) {
        val split = s.split(" ")
        id = split[0].toInt()
        name = split[1]
        age = split[2].toInt()
    }
}
