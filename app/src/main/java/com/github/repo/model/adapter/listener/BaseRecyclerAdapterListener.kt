package com.github.repo.model.adapter.listener

/**
 * Common method used for all RecyclerView who extends this interface.
 */

interface BaseRecyclerAdapterListener<T> {
    fun onClickItem(data: T, pos: Int)
}
