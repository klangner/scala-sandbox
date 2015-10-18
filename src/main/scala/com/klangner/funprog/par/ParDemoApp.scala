package com.klangner.funprog.par

object ParDemoApp {

  def main(args: Array[String]) {
    val ints = IndexedSeq(1, 2, 1, 3, 6)
    println(sum(ints).run)
  }

  def sum(ints: IndexedSeq[Int]): Par[Int] = {
    if(ints.size <= 1)
      Par.unit(ints.headOption.getOrElse(0))
    else{
      val (l, r) = ints.splitAt(ints.length/2)
      val sum1: Par[Int] = sum(l)
      val sum2: Par[Int] = sum(r)
      Par.map2(Par.fork(sum1), Par.fork(sum2))(_+_)
    }
  }
}
