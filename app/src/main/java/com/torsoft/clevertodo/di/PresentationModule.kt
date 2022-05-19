package com.torsoft.clevertodo.di

import com.torsoft.clevertodo.ui.validator.DomainValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun domainValidator(): DomainValidator {
        return DomainValidator()
    }

}
