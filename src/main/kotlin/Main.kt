abstract class CrudServise <T:Item>{

    protected  val items = mutableListOf<T>()
    fun add (elem:T):T{
        items +=elem
        return items.last()
    }

    fun update(elem:T):Boolean {
        for ((index, old) in items.withIndex()) {
            if (old.id == elem.id) {
                items[index] = elem
                return true
            }
        }
        return false

    }

    fun printItems()= println(items)


}

interface Item{
    val id:Int
}
data class Post (override val id:Int,val text :String):Item
data class Note ( override  val id :Int , val text :String) :Item
object Wallservice :CrudServise<Post>()
object Noteservice :CrudServise<Note>()

fun main(args: Array<String>) {
    Wallservice.add(Post(1,"123123"))
    Noteservice.add(Note(2,"12312312333"))
    Noteservice.printItems()
    Noteservice.update(Note(2,"22222222"))
Noteservice.printItems()
}