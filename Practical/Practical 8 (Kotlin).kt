fun main() {
   print("Enter your name: ")
   val name = readLine()
 
   print("Enter a number between 1 and 10: ")
   val input = readLine()
   val a = input?.toInt()
 
   if (a != null && a in 1..10) {
       println("Hello $name!")
   } else {
       println("Incorrect input")
   }
}