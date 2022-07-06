package com.emreonal.core.domain.mapper

interface Mapper<E, D> {
    fun mapFromEntity(item: E?): D?
    fun mapToEntity(item: D?): E?
}