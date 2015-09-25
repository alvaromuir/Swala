//: Worksheet - noun: A informal document to record information

print("Hello, world!")

// Simple Values

var myVariable = 42
myVariable
val myConstant = 42
myConstant

val implicitInteger = 70
val implicitDouble = 70.0
val explicitDouble:Double = 70

val label = "The width is "
val width = 94
val widthLabel = label + width.toString

val apples = 3
val oranges = 5
val appleSummary = s"I have $apples apples."
val fruitSummary = s"I have ${apples + oranges} pieces of fruit."

var shoppingList =  collection.mutable.MutableList("catfish", "water", "tulips", "blue paint")
shoppingList(1) = "bottle of water"

var occupations = collection.mutable.Map[String, String](
  "Malcom" -> "Captain",
  "Kaylee" -> "Mechanic"
)

occupations("Jayne") = "Public Relations"

val emptyList = List()
val emptyMap = Map()

shoppingList = collection.mutable.MutableList()
occupations = collection.mutable.Map[String, String]()


// Control Flow

val individualScores = List(75, 43, 103, 87, 12)
var teamScore = 0

for (score <- individualScores) {
  if (score >  50) {
    teamScore += 3
  } else {
    teamScore += 1
  }
}

print(teamScore)


var optionalString: Option[String]  = Option("Hello")
println(optionalString == null)

var optionalName: Option[String] = Option("Johnny Appleseed")
var greeting = "Hello!"
if (optionalName.isDefined) {
  greeting = s"Hello ${optionalName.get}"
}



val vegetable =  "red pepper"
val vegetableComment = vegetable match {
  case "celery" => "Add some raisins and make ants on a log."
  case "cucumber" | "watercress" => "That would make a good tea sandwich."
  case x if x.endsWith("pepper") => s"Is it a spicy $x?"
  case other => "Everything tastes good in soup."
}

val interestingNumbers = Map(
  "Prime" -> List(2,3,5,7,11,13),
  "Fibonacci" -> List(1,1,2,3,5,8),
  "Square" -> List(1,4,9,16,25)
)

var largest = 0

for((kind, numbers) <- interestingNumbers) {
  for (number <- numbers) {
    if (number > largest) {
      largest = number
    }
  }
}

print(largest)

var n = 2
while (n < 100) {
  n = n * 2
}
print(n)

var m = 2
do {
  m = m * 2
} while (m < 100)
print(m)


var firstForLoop = 0
for(i <- 0 until 4){
  firstForLoop += i
}
print(firstForLoop)


var secondForLoop = 0
for(i <- 0 until 4) yield {
  secondForLoop += 1
}
print(secondForLoop)


// Functions and Closures

def greet(name: String, day: String): String = {
  s"Hello $name, today is $day"
}

greet("Bob", day = "Tuesday")


def calculateStatistics(scores: List[Int]): Map[String, Int] = {
  var min = scores.head
  var max = scores.head
  var sum = 0

  for (score <- scores) {
    if (score > max) {
      max = score
    } else if (score < min) {
      min = score
    }
    sum += score
  }
  Map("max" -> max, "min" -> min, "sum" -> sum)
}

val statistics = calculateStatistics(List(5, 3, 100, 3, 9))
print(statistics("sum"))
print(statistics.toList(2)._2)


def sumOf(numbers: Int*): Int = {
  var sum = 0
  for (number <- numbers) {
    sum += number
  }
  sum
}

sumOf()
sumOf(42, 597, 12)

def returnFifteen(): Int = {
  var y = 10
  def add(): Unit = {
    y += 5
  }
  add()
  y
}

returnFifteen()


def makeIncrement(): Int => Int = {
  def addOne(number: Int): Int = {
    1 + number
  }
  addOne
}

var increment = makeIncrement()
increment(7)


def hasAnyMatches(list: List[Int], condition: Int => Boolean): Boolean = {
  for (item <- list) {
    if (condition(item)) {
      return true
    }
  }
  false
}

def lessThanTen(number: Int): Boolean = {
  number < 10
}

var numbers = List(20, 19, 7, 12)

hasAnyMatches(numbers, condition = lessThanTen)


val mappedNumbers = numbers.map(number => 3 * number)
print(mappedNumbers)

val sortedNumbers = numbers.sortWith {_>_}
print(sortedNumbers)

// Objects and Classes

class Shape() {
  var numberOfSides = 0

  def simpleDescription(): String = {
    s"A shape with $numberOfSides sides."
  }
}


var shape = new Shape
shape.numberOfSides = 7
var shapeDescription = shape.simpleDescription()


class NamedShape(name: String = "") {
  var numberOfSides = 0

  //  Scala does not have an 'init'
  //  function as found in
  //  swift 2

  def simpleDescription(): String = {
    s"A shape with $numberOfSides sides."
  }
}

class Square(sideLength: Double, name: String = "") extends NamedShape {
  //  Scala does not have an 'init'
  //  function as found in
  //  swift 2
  //  no need to use super either
  //  when extending a class
  //  (hint: traits)
  this.numberOfSides = 4

  def area(): Double = {
    sideLength * sideLength
  }

  override def simpleDescription(): String = {
    s"A square with sides of length $sideLength/"
  }
}

val test = new Square(sideLength = 5.2, name = "my test suqare")
test.area()
test.simpleDescription()

