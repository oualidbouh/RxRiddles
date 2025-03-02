package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle19 {
  /**
   * Use the given [Interaction] interface and use its listener to transform the [Int] callback to an Observable that emits every time the listener is called.
   * When the Observable is being disposed the listener should be set to null.
   *
   * Use case: Transform any listener into an Observable.
   */
  fun solve(interaction: Interaction): Observable<Int> {
    return Observable.create<Int>{ emitter ->
      interaction.listener = emitter::onNext

      emitter.setCancellable {
        interaction.listener = null
      }
    }
  }

  interface Interaction {
    var listener: ((Int) -> Unit)?
  }
}
