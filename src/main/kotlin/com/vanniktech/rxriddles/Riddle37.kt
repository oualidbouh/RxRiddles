package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable
import java.io.IOException
import java.util.function.BiFunction

object Riddle37 {
  /**
   * Return an Observable that emits 'false' when the [source] emits an IOException.
   *
   * Use case: You want to recover from an expected error and map them to a particular result.
   */
  fun solve(source: Observable<Boolean>): Observable<Boolean> {
    return source.onErrorResumeNext { t: Throwable ->
      when (t) {
        is IOException -> Observable.just(false)
        else -> Observable.error(t)
      }
    }
  }
}
