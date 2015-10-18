package com.klangner.funprog.par

object ParDemoApp {

  def main(args: Array[String]) {
    val ints = IndexedSeq(1, 2, 1, 3, 6)
    println(sum(ints))
  }

  def sum(ints: IndexedSeq[Int]): Int = {
    if(ints.size <= 1)
      ints.headOption.getOrElse(0)
    else{
      val (l, r) = ints.splitAt(ints.length/2)
      val sum1: Par[Int] = Par.unit(sum(l))
      val sum2: Par[Int] = Par.unit(sum(r))
      sum1.get + sum2.get
    }
  }
}
