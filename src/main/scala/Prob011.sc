val input = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"
val matrix = input.split("\n").map(_.split("\\s"))
matrix(0)
matrix(2)(2).toLong
matrix(4)(3).toLong
Integer.parseInt("01")
// vertical
val can = for ( i <- 0 to 19; arr <- matrix ) yield arr(i)
can.grouped(20).toList
// diagonal
// from (0,16) , (0, 15), .. (0,0), (1, 0), ..(16,0) find diagonal (x  + 1 , y + 1 )
// from (0, 3), (0 , 4) ... (0,16), (1, 16), .. (16,16) find diagonal as ( x + 1, y - 1)
16 to 0 by -1 map ((0, _))
// below is lazy
//(16 to 0 by -1).view map ((0, _))
1 to 16 zip Stream.continually(0)
// diagonal right down from right upper corner
val startsA = (16 to 0 by -1 map ((0, _))) ++ (1 to 16 zip Stream.continually(0))
// diagonal left down from left upper corner
val startsB = (3 to 16 map ((0, _))) ++ (1 to 16 zip Stream.continually(16))
// append following elements until it satisfy the restrictions.
val dd = startsA.map(
  start => {
    (0 to 19).takeWhile(a => (a + start._1 < 20) & (a + start._2 < 20)).map(add => (start._1 + add, start._2 + add))
  }
)

val ll = startsB.map(
  start => {
    (0 to 19).takeWhile(a => (a + start._1 < 20) & (start._2 -a > -1)).map(add => (start._1 + add, start._2 - add))
  }
)


val s = Stream.from(5).takeWhile( elem => (elem < 19) & (elem > 2)) foreach println


List(1,2,3,4,5).sliding(6).toList

List(1,3,4,5,6,2,3,2).grouped(3).foreach(print)