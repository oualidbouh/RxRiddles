package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable
import jdk.nashorn.internal.objects.NativeRegExp.test

object Riddle3 {
  /**
   * Don't emit odd numbers from the [source] Observable.
   *
   * Use case: You want to filter certain items out.
   */
  fun solve(source: Observable<Int>): Observable<Int> {
    return source.filter { i -> i % 2 == 0 }
  }
}
