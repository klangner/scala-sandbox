package com.klangner.funprog.par


case class Par[A](run: () => A){

  def get: A = ???
}

object Par{

  def unit[A](a: => A): Par[A] = ???
}
