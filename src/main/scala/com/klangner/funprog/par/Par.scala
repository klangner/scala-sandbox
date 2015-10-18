package com.klangner.funprog.par


case class Par[A](computation: () => A){

  def run: A = computation()
}

object Par{

  def unit[A](a: => A): Par[A] = Par(() => a)

  def map2[A,B,C](p: Par[A], q: Par[B])(f: (A,B) => C): Par[C] = unit(f(p.run, q.run))
  
  def fork[A](a: => Par[A]): Par[A] = a
}
